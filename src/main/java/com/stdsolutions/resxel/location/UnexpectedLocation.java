package com.stdsolutions.resxel.location;

import com.stdsolutions.resxel.Location;

import java.nio.file.Path;

public class UnexpectedLocation implements Location {

    public UnexpectedLocation(String s) {

    }

    @Override
    public String scheme() {
        return "unexpected";
    }

    @Override
    public Path source() {
        return Path.of("");
    }

    @Override
    public String path() {
        return "";
    }
}
