package com.stdsolutions.resxel.location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationOfTest {

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
        LocationOf locationOf = new LocationOf(input);

        assertEquals("file", locationOf.scheme());
        assertEquals(Path.of(""), locationOf.source());
        assertEquals(expectedPath, locationOf.path());
    }

    @ParameterizedTest
    @CsvSource({
            "jar:file:/path/to/resxel.jar, jar:file:/path/to/resxel.jar, /",
            "jar:file:/path/to/resxel.jar!/, jar:file:/path/to/resxel.jar, /",
            "jar:file:/path/to/resxel.jar!/to/file.txt, jar:file:/path/to/resxel.jar, /to/file.txt",
    })
    @DisplayName("handle file locations on jar")
    void handleFileLocationsOnJar(String input, String expectedSource, String expectedPath) {
        LocationOf locationOf = new LocationOf(input);

        assertEquals("jar:file", locationOf.scheme());
        assertEquals(Path.of(expectedSource), locationOf.source());
        assertEquals(expectedPath, locationOf.path());
    }
}
