package com.stdsolutions.resxel.filesystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationTest {

    // ===================================
    // ---------- REGULAR FILES ----------
    // ===================================

    @ParameterizedTest
    @CsvSource({
            "/absolute/path/to/resxel.jar, /absolute/path/to/resxel.jar",
            "file:/absolute/path/to/resxel.jar, /absolute/path/to/resxel.jar",
            "relative/path/to/file.txt, relative/path/to/file.txt",
            "file:relative/path/to/file.txt, relative/path/to/file.txt",
            "file:any!/symbols?q, any!/symbols?q",
            "file:jar:any!/symbols?q, jar:any!/symbols?q",
            "C:/jar:any!/symbols?q, C:/jar:any!/symbols?q",
    })
    @DisplayName("handle file locations on filesystem")
    void handleFileLocationsOnFilesystem(String input, String expectedPath) {
        Location location = new Location(input);

        assertEquals("file", location.scheme());
        assertEquals(Path.of(""), location.source());
        assertEquals(expectedPath, location.path());
    }

    @ParameterizedTest
    @CsvSource({
            "jar:file:/path/to/resxel.jar, jar:file:/absolute/path/to/resxel.jar, /",
            "jar:file:/path/to/resxel.jar!/, jar:file:/absolute/path/to/resxel.jar, /",
            "jar:file:/path/to/resxel.jar!/to/file.txt, jar:file:/absolute/path/to/resxel.jar, /to/file.txt",
    })
    @DisplayName("handle file locations on jar")
    void handleFileLocationsOnJar(String input, String expectedSource, String expectedPath) {
        Location location = new Location(input);

        assertEquals("jar:file", location.scheme());
        assertEquals(Path.of(expectedSource), location.source());
        assertEquals(expectedPath, location.path());
    }



//
//    @Test
//    void shouldCreateLocationFromURI() throws Exception {
//        URI uri = new URI("jar:file:/home/user/lib.jar!/META-INF");
//        Location location = new Location(uri);
//
//        assertEquals("jar:file", location.scheme());
//        assertEquals("/META-INF", location.dir());
//    }
//
//    @Test
//    void shouldCreateLocationFromURL() throws Exception {
//        URL url = new URL("jar:file:/home/user/lib.jar!/META-INF");
//        Location location = new Location(url);
//
//        assertEquals("jar:file", location.scheme());
//        assertEquals("/META-INF", location.dir());
//    }
//
//    @Test
//    void shouldHandleNullURI() {
//        Location location = new Location((URI) null);
//
//        assertEquals("null", location.scheme());
//        assertEquals("/", location.dir());
//    }
//
//    @Test
//    void shouldHandleNullURL() {
//        Location location = new Location((URL) null);
//
//        assertEquals("null", location.scheme());
//        assertEquals("/", location.dir());
//    }
//
//    @Test
//    void shouldReturnDefaultSchemeWhenInvalid() {
//        Location location = new Location("x/y");
//
//        assertEquals("file", location.scheme());
//    }
//
//    @Test
//    void shouldExtractRootPath() {
//        Location location = new Location("jar:file:/home/user/lib.jar!/META-INF");
//
//        Path root = location.root();
//        assertNotNull(root);
//        assertEquals("jar:file:/home/user/lib.jar", root.toString());
//    }
//
//    @Test
//    void shouldExtractDirPath() {
//        Location location = new Location("jar:file:/home/user/lib.jar!/META-INF/resources");
//
//        assertEquals("/META-INF/resources", location.dir());
//    }
//
//    @Test
//    void shouldReturnRootSlashWhenNoDirSeparator() throws Exception {
//        URI uri = new URI("file:/home/user/documents");
//        Location location = new Location(uri);
//
//        assertEquals("/", location.dir());
//    }
//
//    @Test
//    void shouldHandleComplexJarLocation() throws Exception {
//        URI uri = new URI("jar:file:/opt/app/application.jar!/BOOT-INF/classes");
//        Location location = new Location(uri);
//
//        assertEquals("jar:file", location.scheme());
//        assertEquals("jar:file:/opt/app/application.jar", location.root().toString());
//        assertEquals("/BOOT-INF/classes", location.dir());
//    }
//
//    @Test
//    void shouldHandleHttpScheme() throws Exception {
//        URL url = new URL("http://example.com/resources!/data");
//        Location location = new Location(url);
//
//        assertEquals("http", location.scheme());
//        assertEquals("/data", location.dir());
//    }

}
