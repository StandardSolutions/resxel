/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.jarfile;

import com.stdsolutions.resxel.Location;
import java.nio.file.Path;

/**
 * JAR file-based location implementation.
 *
 * @since 0.0.27
 */
final class JarFileLocation implements Location {

    /**
     * The location string.
     */
    private final String location;

    /**
     * Creates a new JarFileLocation.
     *
     * @param location The location string
     */
    JarFileLocation(final String location) {
        this.location = location;
    }

    @Override
    public Path path() {
        return Path.of(location);
    }

    //    @Override
    //    public String scheme() {
    //        return "jar:file";
    //    }
    //
    //    @Override
    //    public URI source() {
    //        final int idx = location.indexOf("!/");
    //        return idx == -1 ? URI.create(location) : URI.create(location.substring(0, idx));
    //    }
    //
    //    @Override
    //    public String path() {
    //        final int idx = location.indexOf("!/");
    //        return idx == -1 ? "/" : location.substring(idx + 1);
    //    }
}
