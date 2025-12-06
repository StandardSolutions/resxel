package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.shared.Result;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

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
        return Files.readAllBytes(location.path());
    }

    @Override
    public Result<String> content() {
        try {
            String s = Files.readString(location.path(), StandardCharsets.UTF_8);
            return new Result<>(s);
        } catch (IOException e) {
            return new Result<>("");
        }
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