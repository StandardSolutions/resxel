package com.stdsolutions.resxel.location.jar;

import com.stdsolutions.resxel.Location;

public class JarType implements Location.Type {

    @Override
    public boolean support(String path) {
        return false;
    }

    @Override
    public Location toLocation(String path) {
        return null;
    }
}