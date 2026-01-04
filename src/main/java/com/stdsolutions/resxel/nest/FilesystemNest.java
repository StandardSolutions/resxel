/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.nest;

import com.stdsolutions.resxel.Scope;
import java.util.List;
import java.util.Set;

/**
 * Filesystem-based nest implementation.
 *
 * @since 0.0.27
 */
public class FilesystemNest {

    /**
     * The list of filesystem locations.
     */
    private final List<String> locations;

    /**
     * Creates a new FilesystemNest.
     *
     * @param location The location path
     */
    public FilesystemNest(final String location) {
        this.locations = List.of(location);
    }

    /**
     * Creates a new FilesystemNest.
     *
     * @param locations The location paths
     */
    public FilesystemNest(final List<String> locations) {
        this.locations = locations;
    }

    /**
     * Returns all locations.
     *
     * @return Set of scopes
     */
    public static Set<Scope> locations() {
        return Set.of();
    }
}
