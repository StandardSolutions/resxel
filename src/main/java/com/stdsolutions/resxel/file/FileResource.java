/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.shared.Result;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * File-based resource implementation.
 *
 * @since 0.0.27
 */
final class FileResource implements Resource {

    /**
     * The file location.
     */
    private final Location location;

    /**
     * Creates a new FileResource.
     *
     * @param path The file path
     */
    public FileResource(final String path) {
        this.location = new FileLocation(path);
    }

    /**
     * Creates a new FileResource.
     *
     * @param location The file location
     */
    public FileResource(final FileLocation location) {
        this.location = location;
    }

    @Override
    public Result<byte[]> asBytes() {
        return Result.tryCatch(() -> Files.readAllBytes(location.path()));
    }

    @Override
    public Result<String> asString() {
        return Result.tryCatch(() -> Files.readString(location.path(), StandardCharsets.UTF_8));
    }

    @Override
    public Location location() {
        return location;
    }
}
