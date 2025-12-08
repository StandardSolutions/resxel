package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.shared.SafedPath;

import java.nio.file.Path;

final class FileLocation implements Location {

    private final String value;

    public FileLocation(final String value) {
        this.value = value;
    }

    public FileLocation(final Path path) {
        this.value = path.toString();
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
    public Path path() {
        final String unPrefixed = value.startsWith("file:") ? value.substring(5) : value;
        return Path.of(new SafedPath(unPrefixed).value());
    }
}