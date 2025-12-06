package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Scope;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileResource implements Resource {

    private final Location location;

    public FileResource(final String path) {
        this.location = new FileLocation(path);
    }

    public FileResource(final Location location) {
        this.location = location;
    }

    @Override
    public byte[] asBytes() throws IOException {
        return Files.readAllBytes(Path.of(location.path()));
    }

    @Override
    public String content() {
        return "";
    }

    @Override
    public Scope location() {
        return null;
    }

//    @Override
//    public Origin origin() {
//        return new Origin() {
//            @Override
//            public String location() {
//                return path.toString();
//            }
//
//            @Override
//            public String type() {
//                return "file";
//            }
//        };
//    }
}