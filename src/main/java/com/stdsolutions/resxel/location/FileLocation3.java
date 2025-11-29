package com.stdsolutions.resxel.location;

import com.stdsolutions.resxel.Location3;

import java.net.URI;

final class FileLocation3 implements Location3 {

    private final String location;

    public FileLocation3(final String location) {
        this.location = location;
    }

    @Override
    public String scheme() {
        return "file";
    }

    @Override
    public URI source() {
        return URI.create("");
    }

    @Override
    public String path() {
        final String unPrefixed = location.startsWith("file:") ? location.substring(5) : location;
        return new SafedPath(unPrefixed).value();
    }
}
