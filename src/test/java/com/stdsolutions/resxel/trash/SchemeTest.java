package com.stdsolutions.resxel.trash;

import com.stdsolutions.resxel.shared.Scheme;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SchemeTest {

    @ParameterizedTest
    @CsvSource({
            "file:/absolute/path, file, 5",
            "jar:file:/path/to/file.jar, jar:file, 9",
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
    void asStringSchemeValue(String location, String expectedScheme, int expectedLength) {
        Scheme scheme = new Scheme(location);

        assertAll(
                () -> assertEquals(expectedScheme, scheme.asString()),
                () -> assertEquals(expectedLength, scheme.cutIndex())
        );
    }

    @Test
    @DisplayName("should throw NullPointerException for null location")
    void shouldThrowNpeForNullLocation() {
        assertThrows(NullPointerException.class, () -> new Scheme(null));
    }
}