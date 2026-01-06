/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.shared.SafedPath;
import java.nio.file.Path;

/**
 * File-based location implementation.
 *
 * @since 0.0.27
 */
final class FileLocation implements Location {

    /**
     * The path value.
     */
    private final String value;

    /**
     * Creates a new FileLocation.
     *
     * @param value The path value
     */
    FileLocation(final String value) {
        this.value = value;
    }

    /**
     * Creates a new FileLocation from a Path.
     *
     * @param path The path
     */
    FileLocation(final Path path) {
        this(path.toString());
    }

    //
    //    @Override
    //    public String scheme() {
    //        return "file";
    //    }
    //
    //    @Override
    //    public URI source() {
    //        return URI.create("");
    //    }
    //
    @Override
    public Path path() {
        String unprefixed = this.value;
        if (this.value.startsWith("file:")) {
            unprefixed = this.value.substring(5);
        }
        return Path.of(new SafedPath(unprefixed).value());
    }

}
