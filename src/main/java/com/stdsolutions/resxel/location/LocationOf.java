package com.stdsolutions.resxel.location;

import com.stdsolutions.resxel.Location;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LocationOf implements Location {

    private static final Map<String, Function<String, Location>> LOCATION_MAP = Map.of(
            "jar:file", JarFileLocation::new,
            "file", FileLocation::new
    );

    private final Location location;


    public LocationOf(final String location) {

        final Scheme scheme = new Scheme(location);
        this.location = LOCATION_MAP
                .getOrDefault(scheme.asString(), UnexpectedLocation::new)
                .apply(location);
    }

    @Override
    public String scheme() {
        return location.scheme();
    }

    @Override
    public Path source() {
        return location.source();
    }

    @Override
    public String path() {
        return location.path();
    }

    @Override
    public String toString() {
        return "LocationOf{" +
                "scheme=" + location.scheme() +
                ", source=" + location.source() +
                ", path=" + location.path() +
                '}';
    }

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
    static final class Scheme {

        /**
         * Pattern matching URI schemes according to RFC 3986 where scheme as:
         * {@code ALPHA *( ALPHA / DIGIT / "+" / "-" / "." )}. The pattern requires
         * at least 2 characters to distinguish from Windows drive letters.
         */
        private static final Pattern SCHEME_PATTERN = Pattern.compile("(^[a-zA-Z][a-zA-Z0-9+.-]+):");

        /**
         * The original location string to parse.
         */
        private final String location;

        /**
         * Constructs a new ParsedScheme from the given location string.
         *
         * @param location the resource location string to parse
         */
        Scheme(final String location) {
            Objects.requireNonNull(location, "Location can't be NULL");
            this.location = location;
        }

        /**
         * Returns the URI scheme as string.
         * <p>
         * If no valid scheme is found in the location string, returns "file" as the default.
         * </p>
         *
         * @return the URI scheme (e.g., "http", "https", "jar") or "file" if none found
         */
        String asString() {
            String rem = location;
            while (true) {
                final Matcher matcher = SCHEME_PATTERN.matcher(rem);
                if (matcher.find()) {
                    rem = rem.substring(matcher.end());
                } else {
                    break;
                }
            }
            if (rem.length() == location.length()) {
                return "file";
            }
            return location.substring(0, location.length() - rem.length() - 1);
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
            return matcher.find() ? this.asString().length() + 1 : 0;
        }
    }
}