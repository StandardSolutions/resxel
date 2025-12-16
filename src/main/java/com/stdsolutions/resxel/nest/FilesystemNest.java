package com.stdsolutions.resxel.nest;

import com.stdsolutions.resxel.Scope;
import java.util.List;
import java.util.Set;

public class FilesystemNest {

    private final List<String> locations;

    public FilesystemNest(final String location) {
        this.locations = List.of(location);
    }

    public FilesystemNest(final List<String> locations) {
        this.locations = locations;
    }

    public Set<Scope> locations() {
        return Set.of();
    }
}