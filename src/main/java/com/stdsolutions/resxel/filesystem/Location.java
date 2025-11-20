package com.stdsolutions.resxel.filesystem;

import java.nio.file.Path;

final class Location {

    private static final String DEFAULT_LOCATION = "null:/";

    private final String value;

    public Location(final String location) {
        this.value = location == null ? DEFAULT_LOCATION : location;
    }

    public String scheme() {
        return new ParsedScheme(value).value();
    }

    public Path source() {
        final ParsedScheme scheme = new ParsedScheme(value);
        if ("file".equals(scheme.value())) {
            return Path.of("");
        }

        final int idx = value.indexOf("!/");
        final String root = idx == -1 ? value : value.substring(0, idx);
        return Path.of(root);
    }

    public String path() {
        final ParsedScheme scheme = new ParsedScheme(value);
        return value.substring(scheme.cutPoint());
    }
}