package com.stdsolutions.resxel;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

public final class Location {

    private static final String DEFAULT_LOCATION = "null:/";

    private final String value;

    public Location(final String location) {
        this.value = location == null ? DEFAULT_LOCATION : location;
    }

    public Location(final URI uri) {
        this.value = uri == null ? DEFAULT_LOCATION : uri.toString();
    }

    public Location(final URL url) {
        this.value = url == null ? DEFAULT_LOCATION : url.toString();
    }

    public String scheme() {
        final int idx = value.indexOf(":/");
        if (idx < 2) {
            return "file";
        }
        return value.substring(0, idx);
    }

    public Path root() {
        if ("file".equals(this.scheme())) {
            return Path.of(this.value);
        }

        final int idx = value.indexOf("!/");
        final String root = idx == -1 ? value : value.substring(0, idx);
        return Path.of(root);
    }

    public String dir() {
        if ("file".equals(this.scheme())) {
            return value.substring(5);
        }
        final int idx = value.indexOf("!/");
        if (idx == -1) {
            return "/";
        }
        return value.substring(idx + 1);
    }
}