package com.stdsolutions.resxel.location;

import com.stdsolutions.resxel.Location;

import java.nio.file.Path;

public class JarFileLocation implements Location {

    private final String location;

    public JarFileLocation(String location) {
        this.location = location;
    }

    @Override
    public String scheme() {
        return "jar:file";
    }

    @Override
    public Path source() {
        final int idx = location.indexOf("!/");
        return idx == -1 ? Path.of(location) : Path.of(location.substring(0, idx));
    }

    @Override
    public String path() {
        final int idx = location.indexOf("!/");
        return idx == -1 ? "/" : location.substring(idx + 1);
    }
}
