package com.stdsolutions.resxel.location.unexpected;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;

import java.util.Set;

public final class UnexpectedLocation implements Location {

    public UnexpectedLocation(String s) {

    }

    @Override
    public Set<Resource> resources() {
        return Set.of();
    }

    @Override
    public Set<Resource> resources(int maxDepth) {
        return Set.of();
    }

    @Override
    public boolean contains(String filename) {
        return false;
    }
}
