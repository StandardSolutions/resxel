package com.stdsolutions.resxel.sources;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.location.file.FileType;
import com.stdsolutions.resxel.location.jar.JarFileType;
import com.stdsolutions.resxel.location.Storage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ClasspathThreadNest {

    private final String resource;

    private final Storage storage;

    public ClasspathThreadNest(final String resource, final Collection<Location.Type> supportedTypes) {
        this.resource = resource;
        this.storage = new Storage(supportedTypes);
    }

    public ClasspathThreadNest(final String resource) {
        this(resource, Set.of(new JarFileType(), new FileType()));
    }

    public Set<Location> locations() throws IOException {
        Set<Location> locations = new HashSet<>();
        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(resource);
        while (classpathResources.hasMoreElements()) {
            Location l = storage.location(String.valueOf(classpathResources.nextElement()));
            locations.add(l);
        }
        return Collections.unmodifiableSet(locations);
    }
}