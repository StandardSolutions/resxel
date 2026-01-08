/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.shared;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parses and extracts the URI scheme from a resource location string.
 * <p>
 * This class follows RFC 3986 specification for URI schemes. To distinguish
 * from Windows drive letters (e.g., "C:"), the scheme must be at least 2
 * characters long. If no valid scheme is found, defaults to "file".
 * </p>
 *
 * @see <a href="https://www.rfc-editor.org/rfc/rfc3986#section-3.1">RFC 3986 Section 3.1</a>
 * @since 0.0.27
 */
public final class Scheme {

    /**
     * Pattern matching URI schemes according to RFC 3986 where scheme as:
     * {@code ALPHA *( ALPHA / DIGIT / "+" / "-" / "." )}. Multiple schemes
     * allowed. The pattern requires at least 2 characters to distinguish from
     * Windows drive letters.
     */
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^(?>[a-zA-Z][a-zA-Z0-9+.-]+:)+");

    /**
     * The original location string to parse.
     */
    private final String value;

    /**
     * Constructs a new ParsedScheme from the given value string.
     *
     * @param value The resource value string to parse
     */
    public Scheme(final String value) {
        Objects.requireNonNull(value, "Location can't be NULL");
        this.value = value;
    }

    /**
     * Returns the URI scheme as string.
     * <p>
     * If no valid scheme is found in the location string, returns "file" as the default.
     * </p>
     *
     * @return The URI scheme (e.g., "http", "https", "jar") or "file" if none found
     */
    public String asString() {
        String scheme = "file";
        final Matcher matcher = SCHEME_PATTERN.matcher(this.value);
        if (matcher.find()) {
            scheme = matcher.group();
            scheme = scheme.substring(0, scheme.length() - 1);
        }
        return scheme;
    }

    /**
     * Returns the index position where the path portion begins after the scheme.
     * <p>
     * This is the position immediately after the colon (":") that follows the scheme.
     * If no scheme is present, returns 0 to indicate the entire string is the path.
     * </p>
     *
     * @return The zero-based index where to cut the scheme from the location string.
     */
    public int cutIndex() {
        final Matcher matcher = SCHEME_PATTERN.matcher(this.value);
        int idx = 0;
        if (matcher.find()) {
            idx = this.asString().length() + 1;
        }
        return idx;
    }
}
