/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel;

import com.stdsolutions.resxel.shared.Scheme;
import com.stdsolutions.resxel.unexpected.UnexpectedMode;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Factory for creating scopes from paths and URLs.
 *
 * @since 0.0.27
 */
public final class ScopeFrom {


    private final Map<String, Scope.Mode> modes;

    /**
     * Creates a new ScopeFrom with the given modes.
     *
     * @param modes collection of modes
     */
    public ScopeFrom(final Collection<Scope.Mode> modes) {
        this.modes = modes.stream()
                .distinct()
                .collect(Collectors.toMap(Scope.Mode::name, Function.identity()));
    }

    /**
     * Creates a scope from the given path.
     *
     * @param path the path
     * @return the scope
     */
    public Scope by(final String path) {
        final Scheme scheme = new Scheme(path);
        final Scope.Mode mode = modes.getOrDefault(scheme.asString(), new UnexpectedMode());
        return mode.scope(path);
    }

    /**
     * Creates a scope from the given URL.
     *
     * @param url the URL
     * @return the scope
     */
    public Scope by(final URL url) {
        return by(String.valueOf(url));
    }
}
