package com.stdsolutions.resxel;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

public final class Location {

    private static final String DEFAULT_LOCATION = "null:/";

    private final String value;

    public Location(final String root, final String dir) {
        if (dir != null && dir.startsWith("/")) {
            this.value = root + "!" + dir;
        } else {
            this.value = root + "!/" + dir;
        }
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
        final int idx = value.indexOf("!/");
        final String root = idx == -1 ? value : value.substring(0, idx);
        return Path.of(root);
    }

    public String dir() {
        final int idx = value.indexOf("!/");
        if (idx == -1) {
            return "/";
        }
        return value.substring(idx + 1);
    }
}