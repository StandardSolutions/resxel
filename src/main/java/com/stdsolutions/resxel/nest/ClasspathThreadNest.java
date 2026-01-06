/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.nest;

import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.ScopeWith;
import com.stdsolutions.resxel.file.FileMode;
import com.stdsolutions.resxel.jarfile.JarFileMode;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * Classpath-based nest implementation using thread context classloader.
 *
 * @since 0.0.27
 */
public final class ClasspathThreadNest {

    /**
     * The resource path.
     */
    private final String path;

    /**
     * The collection of scope modes.
     */
    private final Collection<Scope.Mode> modes;

    /**
     * Creates a new ClasspathThreadNest.
     *
     * @param path       The resource path
     * @param modes The scope modes to use
     */
    public ClasspathThreadNest(final String path, final Collection<Scope.Mode> modes) {
        this.path = path;
        this.modes = modes;
    }

    /**
     * Creates a new ClasspathThreadNest with default modes.
     *
     * @param path The resource path
     */
    public ClasspathThreadNest(final String path) {
        this(path, Set.of(new JarFileMode(), new FileMode()));
    }

    /**
     * Returns all scopes found in classpath.
     *
     * @return Set of scopes
     * @throws IOException if an I/O error occurs
     */
    public Set<Scope> scopes() throws IOException {
        final Set<Scope> scopes = new HashSet<>();
        final Enumeration<URL> resources = Thread.currentThread()
            .getContextClassLoader()
            .getResources(this.path);
        while (resources.hasMoreElements()) {
            final URL url = resources.nextElement();
            final Scope scope = new ScopeWith(this.modes).from(url);
            scopes.add(scope);
        }
        return Collections.unmodifiableSet(scopes);
    }
}
