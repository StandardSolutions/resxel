/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.jarfile;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.shared.Result;

/**
 * JAR file-based resource implementation.
 *
 * @since 0.0.27
 */
final class JarFileResources implements Resource {

    /**
     * The resource location.
     */
    private final Location value;

    /**
     * Creates a new JarFileResources.
     *
     * @param value The resource location
     */
    JarFileResources(final Location value) {
        this.value = value;
    }

    @Override
    public Result<byte[]> asBytes() {
        return new Result.Success<>(new byte[0]);
    }

    @Override
    public Result<String> asString() {
        return new Result.Success<>(this.value.toString());
    }

    @Override
    public Location location() {
        return null;
    }
}
