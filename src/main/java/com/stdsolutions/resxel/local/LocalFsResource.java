package com.stdsolutions.resxel.local;

import com.stdsolutions.resxel.Origin;
import com.stdsolutions.resxel.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LocalFsResource implements Resource {

    private final Path path;

    public LocalFsResource(final Path path) {
        this.path = path;
    }

    @Override
    public byte[] asBytes() throws IOException {
        return Files.readAllBytes(path);
    }

    @Override
    public Origin origin() {
        return new Origin() {
            @Override
            public String location() {
                return path.toString();
            }

            @Override
            public String type() {
                return "file";
            }
        };
    }
}