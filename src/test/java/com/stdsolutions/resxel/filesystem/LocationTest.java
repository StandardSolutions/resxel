package com.stdsolutions.resxel.filesystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationTest {

    // ===================================
    // ---------- REGULAR FILES ----------
    // ===================================

    @Test
    @DisplayName("handle file location on filesystem without scheme")
    void handleFileLocationWithoutScheme() {
        Location location = new Location("/home/user/path/resxel.jar");

        assertEquals("file", location.scheme());
        assertEquals(Path.of(""), location.source());
        assertEquals("/home/user/path/resxel.jar", location.path());
    }

    @Test
    @DisplayName("handle file location on filesystem with scheme")
    void handleFileLocationWithScheme() {
        Location location = new Location("file:/home/user/path/resxel.jar");

        assertEquals("file", location.scheme());
        assertEquals(Path.of(""), location.source());
        assertEquals("/home/user/path/resxel.jar", location.path());
    }

//    @Test
//    void shouldHandleFileWithoutJar() {
//        URI uri = URI.create("/home/user/documents/data.txt");
//        Location location = new Location(uri);
//
//        assertEquals("file", location.scheme());
//        assertEquals("/", location.root());
//        assertEquals("/home/user/documents/data.txt", location.dir());
//    }
//
//    @Test
//    void shouldHandleRelativeFile() {
//        URI uri = URI.create("relative/path/to/file.txt");
//        Location location = new Location(uri);
//
//        assertEquals("file", location.scheme());
//        assertEquals("/", location.root());
//        assertEquals("relative/path/to/file.txt", location.dir());
//    }
//
//
//    @Test
//    void shouldCreateLocationFromRootAndDir() {
//        Location location = new Location("file:/home/user/documents");
//
//        assertEquals("file", location.scheme());
//        assertEquals("/home/user/documents", location.dir());
//    }
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
