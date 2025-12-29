package com.stdsolutions.resxel.trash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScopeFromTest {

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
    void handleFileLocationsOnFilesystem(final String input, final String expectedPath) {
        //Location location = new Locator(input);
//        assertEquals("file", location.scheme());
//        assertEquals(URI.create(""), location.source());
//        assertEquals(expectedPath, location.path());
    }

    @ParameterizedTest
    @CsvSource({
            "jar:file:/path/to/resxel.jar, jar:file:/path/to/resxel.jar, /",
            "jar:file:/path/to/resxel.jar!/, jar:file:/path/to/resxel.jar, /",
            "jar:file:/path/to/resxel.jar!/to/file.txt, jar:file:/path/to/resxel.jar, /to/file.txt",
    })
    @DisplayName("handle file locations on jar")
    void handleFileLocationsOnJar(final String input,
                                  final String expectedSource,
                                  final String expectedPath) {
        // Location location = new Locator(input);
//        assertEquals("jar:file", location3.scheme());
//        assertEquals(URI.create(expectedSource), location3.source());
//        assertEquals(expectedPath, location3.path());
    }
}
