package com.stdsolutions.resxel.sources;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.location.file.FileType;
import com.stdsolutions.resxel.location.jar.JarType;
import com.stdsolutions.resxel.locationold.Locator;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ClasspathThreadSource {

    private final String resource;

    private final Locator locator;

    public ClasspathThreadSource(final String resource, final Collection<Location.Type> supportedTypes) {
        this.resource = resource;
        this.locator = new Locator(supportedTypes);
    }

    public ClasspathThreadSource(final String resource) {
        this(resource, Set.of(new JarType(), new FileType()));
    }

    public Set<Location> locations() throws IOException {
        Set<Location> locations = new HashSet<>();
        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(resource);
        while (classpathResources.hasMoreElements()) {
            Location l = locator.location(String.valueOf(classpathResources.nextElement()));
            locations.add(l);
        }
        return Collections.unmodifiableSet(locations);
    }
}