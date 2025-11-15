package com.stdsolutions.resxel.filesystem;

import java.nio.file.Path;

final class Location {

    private static final String DEFAULT_LOCATION = "null:/";

    private final String value;

    public Location(final String location) {
        this.value = location == null ? DEFAULT_LOCATION : location;
    }

    public String scheme() {
        final int idx = value.indexOf(":");
        if (idx < 2) {
            return "file";
        }
        return value.substring(0, idx);
    }

    public Path source() {
        if ("file".equals(this.scheme())) {
            return Path.of("");
        }

        final int idx = value.indexOf("!/");
        final String root = idx == -1 ? value : value.substring(0, idx);
        return Path.of(root);
    }

    public String path() {
        if ("file".equals(this.scheme())) {
            final int idx = value.contains(":") ? value.indexOf(":") + 1 : 0;
            return value.substring(idx);
        }
        final int idx = value.indexOf("!/");
        if (idx == -1) {
            return "/";
        }
        return value.substring(idx + 1);
    }
}