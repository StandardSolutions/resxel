package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.shared.Result;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

final class FileResource implements Resource {

    private final Location location;

    public FileResource(final String path) {
        this.location = new FileLocation(path);
    }

    public FileResource(final FileLocation location) {
        this.location = location;
    }

    @Override
    public Result<byte[]> asBytes() {
        return Result.tryCatch(() -> Files.readAllBytes(location.path()));
    }

    @Override
    public Result<String> asString() {
        return Result.tryCatch(() -> Files.readString(location.path(), StandardCharsets.UTF_8));
    }

    @Override
    public Location location() {
        return location;
    }
}