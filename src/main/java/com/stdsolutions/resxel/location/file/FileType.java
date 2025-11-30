package com.stdsolutions.resxel.location.file;

import com.stdsolutions.resxel.Location;

public class FileType implements Location.Type {

    @Override
    public boolean support(String path) {
        return false;
    }

    @Override
    public Location toLocation(String path) {
        return null;
    }
}