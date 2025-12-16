package com.stdsolutions.resxel.jarfile;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.shared.Result;

final class JarFileResources implements Resource {

    private final Location location;

    public JarFileResources(final Location location) {
        this.location = location;
    }

    @Override
    public Result<byte[]> asBytes() {
        return new Result.Ok<>(new byte[0]);
    }

    @Override
    public Result<String> asString() {
        return new Result.Ok<>("");
    }

    @Override
    public Location location() {
        return null;
    }
}
