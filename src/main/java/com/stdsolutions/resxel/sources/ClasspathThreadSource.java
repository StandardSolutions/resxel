package com.stdsolutions.resxel.sources;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.locationold.LocationOf;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class ClasspathThreadSource {

    private final String path;


    public ClasspathThreadSource(String path) {
        this.path = path;
    }

    public Set<Location> locations() throws IOException {
        Set<Location> locations = new HashSet<>();
        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (classpathResources.hasMoreElements()) {
            Location l = new LocationOf(classpathResources.nextElement());
            locations.add(l);
        }
        return Collections.unmodifiableSet(locations);
    }
}