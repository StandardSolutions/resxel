package com.stdsolutions.resxel.filesystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationSchemeTest {

    @ParameterizedTest
    @CsvSource({
            "file:/absolute/path, file, 5",
            "jar:file:/path/to/file.jar, jar, 4",
            "http://example.com, http, 5",
            "https://example.com, https, 6",
            "/absolute/path, file, 0",
            "relative/path, file, 0",
            "C:/windows/path, file, 0",
            "D:file.txt, file, 0",
            "a:path, file, 0",
            ":noscheme, file, 0",
            "'', file, 0"
    })
    @DisplayName("should extract scheme value from location")
    void asString(String location, String expectedScheme, int expectedLength) {
        LocationScheme locationScheme = new LocationScheme(location);

        assertAll(
                () -> assertEquals(expectedScheme, locationScheme.asString()),
                () -> assertEquals(expectedLength, locationScheme.cutIndex())
        );
    }
}