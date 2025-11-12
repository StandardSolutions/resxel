package com.stdsolutions.resxel;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void shouldCreateLocationFromRootAndDir() {
        Location location = new Location("file:/home/user/documents");

        assertEquals("file", location.scheme());
        assertEquals("/home/user/documents", location.dir());
    }

    @Test
    void shouldCreateLocationFromURI() throws Exception {
        URI uri = new URI("jar:file:/home/user/lib.jar!/META-INF");
        Location location = new Location(uri);

        assertEquals("jar:file", location.scheme());
        assertEquals("/META-INF", location.dir());
    }

    @Test
    void shouldCreateLocationFromURL() throws Exception {
        URL url = new URL("jar:file:/home/user/lib.jar!/META-INF");
        Location location = new Location(url);

        assertEquals("jar:file", location.scheme());
        assertEquals("/META-INF", location.dir());
    }

    @Test
    void shouldHandleNullURI() {
        Location location = new Location((URI) null);

        assertEquals("null", location.scheme());
        assertEquals("/", location.dir());
    }

    @Test
    void shouldHandleNullURL() {
        Location location = new Location((URL) null);

        assertEquals("null", location.scheme());
        assertEquals("/", location.dir());
    }

    @Test
    void shouldReturnDefaultSchemeWhenInvalid() {
        Location location = new Location("x/y");

        assertEquals("file", location.scheme());
    }

    @Test
    void shouldExtractRootPath() {
        Location location = new Location("jar:file:/home/user/lib.jar!/META-INF");

        Path root = location.root();
        assertNotNull(root);
        assertEquals("jar:file:/home/user/lib.jar", root.toString());
    }

    @Test
    void shouldExtractDirPath() {
        Location location = new Location("jar:file:/home/user/lib.jar!/META-INF/resources");

        assertEquals("/META-INF/resources", location.dir());
    }

    @Test
    void shouldReturnRootSlashWhenNoDirSeparator() throws Exception {
        URI uri = new URI("file:/home/user/documents");
        Location location = new Location(uri);

        assertEquals("/", location.dir());
    }

    @Test
    void shouldHandleComplexJarLocation() throws Exception {
        URI uri = new URI("jar:file:/opt/app/application.jar!/BOOT-INF/classes");
        Location location = new Location(uri);

        assertEquals("jar:file", location.scheme());
        assertEquals("jar:file:/opt/app/application.jar", location.root().toString());
        assertEquals("/BOOT-INF/classes", location.dir());
    }

    @Test
    void shouldHandleHttpScheme() throws Exception {
        URL url = new URL("http://example.com/resources!/data");
        Location location = new Location(url);

        assertEquals("http", location.scheme());
        assertEquals("/data", location.dir());
    }

    @Test
    void shouldHandleJarWithRoot() {
        URI uri = URI.create("/home/sergei/projects/stadnardsolutions/resxel/target/test-classes/jar/resxel.jar!/");
        Location location = new Location(uri);

        assertEquals("jar", location.scheme());
        assertEquals("/home/sergei/projects/stadnardsolutions/resxel/target/test-classes/jar/resxel.jar", location.root());
        assertEquals("/", location.dir());
    }

}
