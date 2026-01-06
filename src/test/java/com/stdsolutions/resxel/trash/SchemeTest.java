/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.trash;

import com.stdsolutions.resxel.shared.Scheme;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Test.
 *
 * @since 0.0.27
 */
final class SchemeTest {

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
    void asStringSchemeValue(final String location, final String schm,
        final int len) {
        final Scheme scheme = new Scheme(location);
        MatcherAssert.assertThat(
            "Scheme string should match expected",
            scheme.asString(),
            Matchers.equalTo(schm)
        );
        MatcherAssert.assertThat(
            "Cut index should match expected",
            scheme.cutIndex(),
            Matchers.equalTo(len)
        );
    }

    @Test
    @DisplayName("should throw NullPointerException for null location")
    void shouldThrowNpeForNullLocation() {
        MatcherAssert.assertThat(
            "Should throw NullPointerException for null input",
            this.throwsNullPointer(null),
            Matchers.is(true)
        );
    }

    /**
     * Checks if creating a Scheme with given location throws NullPointerException.
     *
     * @param location The location string
     * @return True if NullPointerException is thrown, false otherwise
     */
    @SuppressWarnings({
        "PMD.AvoidCatchingNPE",
        "PMD.AvoidCatchingGenericException",
        "PMD.DataflowAnomalyAnalysis"
    })
    private boolean throwsNullPointer(final String location) {
        boolean result;
        try {
            new Scheme(location);
            result = false;
        } catch (final NullPointerException npe) {
            result = true;
        }
        return result;
    }
}
