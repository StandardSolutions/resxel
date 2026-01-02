/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel;

import java.nio.file.Path;

/**
 * Represents a location of a resource.
 *
 * @since 0.0.27
 */
public interface Location {

    /**
     * Returns the path of this location.
     *
     * @return The path
     */
    Path path();
}
