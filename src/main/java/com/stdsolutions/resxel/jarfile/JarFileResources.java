package com.stdsolutions.resxel.jarfile;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Scope;

import java.io.IOException;

final class JarFileResources implements Resource {

    private final Location location;

    public JarFileResources(Location location) {
        this.location = location;
    }

    @Override
    public byte[] asBytes() throws IOException {
        return new byte[0];
    }

    @Override
    public String content() {
        return "";
    }

    @Override
    public Scope location() {
        return null;
    }
}
