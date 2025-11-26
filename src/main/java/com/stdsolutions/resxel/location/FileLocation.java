package com.stdsolutions.resxel.location;

import com.stdsolutions.resxel.Location;

import java.nio.file.Path;

final class FileLocation implements Location {

    private final String location;

    public FileLocation(final String location) {
        this.location = location;
    }

    @Override
    public String scheme() {
        return "file";
    }

    @Override
    public Path source() {
        return Path.of("");
    }

    @Override
    public String path() {
        final String unPrefixed = location.startsWith("file:") ? location.substring(6) : location;
        return new SafeStringPath(unPrefixed).value();
    }
}
