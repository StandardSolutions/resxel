package com.stdsolutions.resxel.nest;

import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.scope.ScopeFrom;
import com.stdsolutions.resxel.scope.file.FileType;
import com.stdsolutions.resxel.scope.jarfile.JarFileType;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ClasspathThreadNest {

    private final String path;

    private final Collection<Scope.Type> types;

    public ClasspathThreadNest(final String path, final Collection<Scope.Type> supportedTypes) {
        this.path = path;
        this.types = supportedTypes;
    }

    public ClasspathThreadNest(final String path) {
        this(path, Set.of(new JarFileType(), new FileType()));
    }

    public Set<Scope> scopes() throws IOException {
        Set<Scope> scopes = new HashSet<>();
        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (classpathResources.hasMoreElements()) {
            Scope scope = new ScopeFrom(types).by(String.valueOf(classpathResources.nextElement()));
            scopes.add(scope);
        }
        return Collections.unmodifiableSet(scopes);
    }
}