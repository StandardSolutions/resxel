package com.stdsolutions.resxel.location.unexpected;

import com.stdsolutions.resxel.Location;

public class UnexpectedType implements Location.Type {

    @Override
    public boolean support(String path) {
        return false;
    }

    @Override
    public Location toLocation(String path) {
        return null;
    }
}