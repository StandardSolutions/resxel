package com.stdsolutions.resxel.location;

import com.stdsolutions.resxel.Location3;

import java.net.URI;

final class JarFileLocation3 implements Location3 {

    private final String location;

    public JarFileLocation3(final String location) {
        this.location = location;
    }

    @Override
    public String scheme() {
        return "jar:file";
    }

    @Override
    public URI source() {
        final int idx = location.indexOf("!/");
        return idx == -1 ? URI.create(location) : URI.create(location.substring(0, idx));
    }

    @Override
    public String path() {
        final int idx = location.indexOf("!/");
        return idx == -1 ? "/" : location.substring(idx + 1);
    }
}