package com.stdsolutions.resxel.sources;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.location.file.FileType;
import com.stdsolutions.resxel.location.jar.JarFileType;
import com.stdsolutions.resxel.location.ScopeOf;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ClasspathThreadNest {

    private final String path;

    private final Collection<Location.Type> types;

    public ClasspathThreadNest(final String path, final Collection<Location.Type> supportedTypes) {
        this.path = path;
        this.types = supportedTypes;
    }

    public ClasspathThreadNest(final String path) {
        this(path, Set.of(new JarFileType(), new FileType()));
    }

    public Set<Location> locations() throws IOException {
        Set<Location> locations = new HashSet<>();
        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (classpathResources.hasMoreElements()) {
            ScopeOf scope = new ScopeOf(types, String.valueOf(classpathResources.nextElement()));
            //locations.addAll(scope.location());
        }
        return Collections.unmodifiableSet(locations);
    }
}