/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.shared;

import java.net.URI;
import java.net.URL;

/**
 * Represents a location split into filesystem and directory parts.
 * @since 0.0.27
 */
public final class PartedLocation {

    /**
     * Indicates whether this location uses the default filesystem.
     */
    private final boolean isDefaultFilesystem;

    /**
     * The filesystem path.
     */
    private final String fsPath;

    /**
     * The directory path.
     */
    private final String dir;

    /**
     * Creates a new PartedLocation.
     * @param fsPath the filesystem path
     * @param dir the directory
     */
    public PartedLocation(final String fsPath, final String dir) {
        this.isDefaultFilesystem = false;
        this.fsPath = fsPath;
        this.dir = dir;
    }

    /**
     * Creates a new PartedLocation from URI.
     * @param uri the URI
     */
    public PartedLocation(final URI uri) {
        this.isDefaultFilesystem = "file".equals(uri.getScheme());
        this.fsPath = null;
        this.dir = null;
    }

    /**
     * Creates a new PartedLocation from URL.
     * @param url the URL
     */
    public PartedLocation(final URL url) {
        this.isDefaultFilesystem = "file".equals(url.getProtocol());
        this.fsPath = null;
        this.dir = null;
    }

}
