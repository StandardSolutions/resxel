/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel;

import java.net.URI;
import java.util.Set;

/**
 * Represents a scope containing resources.
 *
 * @since 0.0.27
 */
public interface Scope {

    /**
     * Returns all resources in this scope.
     *
     * @return set of resources
     */
    Set<Resource> resources();

    /**
     * Returns resources up to the specified depth.
     *
     * @param maxDepth maximum depth to traverse
     * @return set of resources
     */
    Set<Resource> resources(int maxDepth);

    /**
     * Mode for scope operations.
     *
     * @since 0.0.27
     */
    interface Mode {

        /**
         * Returns the name of this mode.
         *
         * @return mode name
         */
        String name();

        /**
         * Creates a scope for the given path.
         *
         * @param path the path
         * @return the scope
         */
        Scope scope(String path);
    }

    /**
     * Metadata for scope.
     *
     * @since 0.0.27
     */
    interface Meta {

        /**
         * Returns the original path.
         *
         * @return original path
         */
        String original();

        /**
         * Returns the scope.
         *
         * @return the scope
         */
        Scope scope();

        /**
         * Returns the mount URI.
         *
         * @return mount URI
         */
        URI mount();
    }
}
