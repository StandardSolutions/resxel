package com.stdsolutions.resxel.sources;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.locationold.LocationOf;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilesystemSource {

    private final List<String> locations;

    public FilesystemSource(final String location) {
        this.locations = List.of(location);
    }

    public FilesystemSource(final List<String> locations) {
        this.locations = locations;
    }

    public Set<Location> locations() {
        return this.locations
                .stream()
                .map(LocationOf::new)
                .collect(Collectors.toUnmodifiableSet());
    }
}