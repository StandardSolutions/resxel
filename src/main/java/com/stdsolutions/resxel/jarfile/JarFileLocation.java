package com.stdsolutions.resxel.jarfile;

import com.stdsolutions.resxel.Location;

import java.nio.file.Path;

final class JarFileLocation implements Location {

    private final String location;

    public JarFileLocation(final String location) {
        this.location = location;
    }

    @Override
    public Path path() {
        return Path.of("");
    }

//    @Override
//    public String scheme() {
//        return "jar:file";
//    }
//
//    @Override
//    public URI source() {
//        final int idx = location.indexOf("!/");
//        return idx == -1 ? URI.create(location) : URI.create(location.substring(0, idx));
//    }
//
//    @Override
//    public String path() {
//        final int idx = location.indexOf("!/");
//        return idx == -1 ? "/" : location.substring(idx + 1);
//    }
}