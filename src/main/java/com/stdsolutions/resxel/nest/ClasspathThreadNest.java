package com.stdsolutions.resxel.nest;

import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.ScopeFrom;
import com.stdsolutions.resxel.file.FileMode;
import com.stdsolutions.resxel.jarfile.JarFileMode;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public final class ClasspathThreadNest {

    private final String path;

    private final Collection<Scope.Mode> modes;

    public ClasspathThreadNest(final String path, final Collection<Scope.Mode> scopeModes) {
        this.path = path;
        this.modes = scopeModes;
    }

    public ClasspathThreadNest(final String path) {
        this(path, Set.of(new JarFileMode(), new FileMode()));
    }

    public Set<Scope> scopes() throws IOException {
        Set<Scope> scopes = new HashSet<>();
        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (classpathResources.hasMoreElements()) {
            URL url = classpathResources.nextElement();
            Scope scope = new ScopeFrom(modes).by(url);
            scopes.add(scope);
        }
        return Collections.unmodifiableSet(scopes);
    }
}
