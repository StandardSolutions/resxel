package com.stdsolutions.resxel.jarfile;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.shared.Result;

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
    public Result<String> content() {
        return new Result<>("");
    }

    @Override
    public Scope location() {
        return null;
    }
}
