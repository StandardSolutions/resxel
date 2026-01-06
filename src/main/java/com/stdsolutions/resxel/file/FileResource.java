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
    private final Location value;

    /**
     * Creates a new FileResource.
     *
     * @param path The file path
     */
    FileResource(final String path) {
        this(new FileLocation(path));
    }

    /**
     * Creates a new FileResource.
     *
     * @param value The file location
     */
    FileResource(final FileLocation value) {
        this.value = value;
    }

    @Override
    public Result<byte[]> asBytes() {
        return Result.tryCatch(() -> Files.readAllBytes(this.value.path()));
    }

    @Override
    public Result<String> asString() {
        return Result.tryCatch(
            () -> Files.readString(this.value.path(), StandardCharsets.UTF_8)
        );
    }

    @Override
    public Location location() {
        return this.value;
    }
}
