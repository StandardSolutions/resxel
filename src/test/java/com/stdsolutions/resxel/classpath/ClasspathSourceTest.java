package com.stdsolutions.resxel.classpath;

import com.stdsolutions.resxel.Origin;
import com.stdsolutions.resxel.ProtocolHandlers;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.sources.ClasspathSource;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClasspathSourceTest {

    @Test
    void testClasspathSource_shouldFindResourcesWithFileProtocol() throws IOException {
        // Given: a ProtocolHandler that handles "file" protocol
        ProtocolHandlers handlers = new ProtocolHandlers(
                "file", TestResource::new
        );

        // When: we create a ClasspathSource for "local" directory in test resources
        ClasspathSource source = new ClasspathSource("local", handlers);
        List<Resource> resources = source.resources().toList();

        System.out.println("Found " + resources.size() + " resource(s):");
        resources.forEach(resource -> {
            Origin origin = resource.origin();
            System.out.println("  - " + origin.type() + ": " + origin.location());
        });

        // Then: we should find resources
        assertFalse(resources.isEmpty(), "Should find at least one resource in classpath");
    }

    @Test
    void testClasspathSource_shouldHandleJarProtocol() throws IOException {
        // Given: a ProtocolHandler that handles both "file" and "jar" protocols
        ProtocolHandlers handlers = new ProtocolHandlers(
                "file", TestResource::new,
                "jar", TestResource::new
        );

        // When: we search for a resource that might be in a jar
        ClasspathSource source = new ClasspathSource("org/slf4j", handlers);
        List<Resource> resources = source.resources().toList();

        // Then: resources should be handled (may be empty if not found, but shouldn't throw)
        assertNotNull(resources);
    }

    @Test
    void testClasspathSource_shouldReturnEmptyForNonExistentPath() throws IOException {
        // Given: a ProtocolHandler
        ProtocolHandlers handlers = new ProtocolHandlers(
                "file", TestResource::new
        );

        // When: we search for a non-existent path
        ClasspathSource source = new ClasspathSource("non/existent/path", handlers);
        List<Resource> resources = source.resources().toList();

        // Then: should return empty list
        assertTrue(resources.isEmpty(), "Should return empty list for non-existent path");
    }

    @Test
    void testClasspathSource_shouldHandleUnsupportedProtocol() throws IOException {
        // Given: a ProtocolHandler that only supports "file" protocol
        ProtocolHandlers handlers = new ProtocolHandlers(
                "file", TestResource::new
        );

        // When: we search for resources (some might be in jars with unsupported protocol)
        ClasspathSource source = new ClasspathSource("local", handlers);
        List<Resource> resources = source.resources().toList();

        // Then: should handle gracefully (not throw exception)
        assertNotNull(resources);
    }

    // Test implementation of Resource
    private static class TestResource implements Resource {
        private final URL url;

        TestResource(URL url) {
            this.url = url;
        }

        @Override
        public byte[] asBytes() throws IOException {
            return url.openStream().readAllBytes();
        }

        @Override
        public Origin origin() {
            return new Origin() {
                @Override
                public String location() {
                    return url.toString();
                }

                @Override
                public String type() {
                    return url.getProtocol();
                }
            };
        }
    }
}