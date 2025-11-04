package com.stdsolutions.resxel.resources;

import com.stdsolutions.resxel.Origin;
import com.stdsolutions.resxel.Resource;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileResource implements Resource {

    private final Path path;

    public FileResource(final Path path) {
        this.path = path;
    }

    public FileResource(final URL url) {
        this.path = Path.of(url.toString());
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