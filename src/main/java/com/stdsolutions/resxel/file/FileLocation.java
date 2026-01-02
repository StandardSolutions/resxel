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
     * @param value the path value
     */
    public FileLocation(final String value) {
        this.value = value;
    }

    /**
     * Creates a new FileLocation from a Path.
     *
     * @param path the path
     */
    public FileLocation(final Path path) {
        this.value = path.toString();
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
        final String unPrefixed = value.startsWith("file:") ? value.substring(5) : value;
        return Path.of(new SafedPath(unPrefixed).value());
    }

}
