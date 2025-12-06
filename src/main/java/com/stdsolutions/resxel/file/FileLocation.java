package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.SafedPath;

final class FileLocation implements Location {

    private final String location;

    public FileLocation(final String location) {
        this.location = location;
    }
//
//    @Override
//    public String scheme() {
//        return "file";
//    }
//
//    @Override
//    public URI source() {
//        return URI.create("");
//    }
//
    @Override
    public String path() {
        final String unPrefixed = location.startsWith("file:") ? location.substring(5) : location;
        return new SafedPath(unPrefixed).value();
    }
}
