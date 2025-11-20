package com.stdsolutions.resxel.filesystem;

import java.nio.file.Path;

final class Location {

    private static final String DEFAULT_LOCATION = "null:/";

    private final String value;

    public Location(final String location) {
        this.value = location == null ? DEFAULT_LOCATION : location;
    }

    public String scheme() {
        return new LocationScheme(value).asString();
    }

    public Path source() {
        final LocationScheme scheme = new LocationScheme(value);
        if ("file".equals(scheme.asString())) {
            return Path.of("");
        }

        final int idx = value.indexOf("!/");
        final String root = idx == -1 ? value : value.substring(0, idx);
        return Path.of(root);
    }

    public String path() {
        final LocationScheme scheme = new LocationScheme(value);
        return value.substring(scheme.cutIndex());
    }
}