package com.stdsolutions.resxel.resources;

import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.Resource;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileResource implements Resource {

    private final String path;

    public FileResource(final String path) {
        this.path = path;
    }

    public FileResource(final URL url) {
        this.path = url.toString();
    }

    @Override
    public byte[] asBytes() throws IOException {
        return Files.readAllBytes(Path.of(path));
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