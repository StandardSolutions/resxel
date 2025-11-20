package com.stdsolutions.resxel.filesystem;

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
 */
class ParsedScheme {

    /**
     * Pattern matching URI schemes according to RFC 3986 where scheme as:
     * {@code ALPHA *( ALPHA / DIGIT / "+" / "-" / "." )}. The pattern requires
     * at least 2 characters to distinguish from Windows drive letters.
     */
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^([a-zA-Z][a-zA-Z0-9+\\-.]+):");

    /**
     * The original location string to parse.
     */
    private final String location;

    /**
     * Constructs a new ParsedScheme from the given location string.
     *
     * @param location the resource location string to parse
     */
    ParsedScheme(final String location) {
        this.location = location;
    }

    /**
     * Returns the URI scheme.
     * <p>
     * If no valid scheme is found in the location string, returns "file" as the default.
     * </p>
     *
     * @return the URI scheme (e.g., "http", "https", "jar") or "file" if none found
     */
    String value() {
        final Matcher matcher = SCHEME_PATTERN.matcher(location);
        return matcher.find() ? matcher.group(1) : "file";
    }

    /**
     * Returns the index position where the path portion begins after the scheme.
     * <p>
     * This is the position immediately after the colon (":") that follows the scheme.
     * If no scheme is present, returns 0 to indicate the entire string is the path.
     * </p>
     *
     * @return the zero-based index where to cut the scheme from the location string.
     */
    int cutIndex() {
        final Matcher matcher = SCHEME_PATTERN.matcher(location);
        return matcher.find() ? matcher.group(1).length() + 1 : 0;
    }
}