/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.shared;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A secure path implementation that validates and sanitizes file paths to prevent security
 * vulnerabilities.
 *
 * <p>This class provides protection against:
 * <ul>
 *   <li>Path traversal attacks (e.g., "../../../etc/passwd")</li>
 *   <li>Empty or blank paths</li>
 * </ul>
 *
 * <p>All paths are normalized and converted to use forward slashes for consistency.
 * Only relative paths within the current directory tree are allowed.
 *
 * @since 0.0.27
 */
public final class SafedPath {

    /**
     * The validated path value.
     */
    private final String value;

    /**
     * Creates a new SafePath from the given string path.
     *
     * @param value The path string to validate and sanitize
     * @throws IllegalArgumentException if the path is null, blank, contains traversal patterns,
     *  or is absolute
     */
    public SafedPath(final String value) {
        final Path path = Paths.get(value).normalize();
        final String normalized = path.toString();
        checkEmptyPath(normalized);
        checkTraversalPattern(normalized);
        this.value = normalized;
    }

    /**
     * Returns the validated path.
     *
     * @return The safe path.
     */
    public String value() {
        return this.toString();
    }

    @Override
    public String toString() {
        return this.value.trim().replace("\\", "/").replaceAll("/+", "/");
    }

    private static void checkEmptyPath(final String path) {
        if (path == null) {
            throw new IllegalArgumentException("Path cannot be null");
        }
        if (path.isBlank()) {
            throw new IllegalArgumentException("Path cannot be blank");
        }
    }

    private static void checkTraversalPattern(final String path) {
        if (path.contains("..")) {
            final String msg = String.format("Path contains unsafe traversal patterns: %s", path);
            throw new IllegalArgumentException(msg);
        }
    }
}
