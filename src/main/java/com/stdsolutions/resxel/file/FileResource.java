/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.shared.Result;
import java.io.IOException;
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
        Result<byte[]> result;
        try {
            result = new Result.Success<>(Files.readAllBytes(this.value.path()));
        } catch (final IOException ex) {
            result = new Result.Err<>(ex);
        }
        return result;
    }

    @Override
    public Result<String> asString() {
        Result<String> result;
        try {
            result = new Result.Success<>(
                Files.readString(this.value.path(), StandardCharsets.UTF_8)
            );
        } catch (final IOException ex) {
            result = new Result.Err<>(ex);
        }
        return result;
    }

    @Override
    public Location location() {
        return this.value;
    }
}
