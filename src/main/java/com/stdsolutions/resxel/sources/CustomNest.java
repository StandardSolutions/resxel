package com.stdsolutions.resxel.sources;

import com.stdsolutions.resxel.Location;

import java.util.List;
import java.util.Set;

public class CustomNest {

    private final List<String> locations;

    public CustomNest(final String location) {
        this.locations = List.of(location);
    }

    public CustomNest(final List<String> locations) {
        this.locations = locations;
    }

    public Set<Location> locations() {
        return Set.of();
    }
}