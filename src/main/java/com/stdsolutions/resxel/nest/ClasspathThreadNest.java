package com.stdsolutions.resxel.nest;

import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.scope.ScopeFrom;
import com.stdsolutions.resxel.scope.file.FileMode;
import com.stdsolutions.resxel.scope.jarfile.JarFileMode;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public final class ClasspathThreadNest {

    private final String path;

    private final Collection<Scope.Mode> modes;

    public ClasspathThreadNest(final String path, final Collection<Scope.Mode> supportedModes) {
        this.path = path;
        this.modes = supportedModes;
    }

    public ClasspathThreadNest(final String path) {
        this(path, Set.of(new JarFileMode(), new FileMode()));
    }

    public Set<Scope> scopes() throws IOException {
        Set<Scope> scopes = new HashSet<>();
        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (classpathResources.hasMoreElements()) {
            Scope scope = new ScopeFrom(modes).by(String.valueOf(classpathResources.nextElement()));
            scopes.add(scope);
        }
        return Collections.unmodifiableSet(scopes);
    }
}