package com.stdsolutions.resxel.location;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A secure path implementation that validates and sanitizes file paths to prevent security vulnerabilities.
 *
 * <p>This class provides protection against:
 * <ul>
 *   <li>Path traversal attacks (e.g., "../../../etc/passwd")</li>
 *   <li>Absolute path access (e.g., "/etc/passwd")</li>
 *   <li>Empty or blank paths</li>
 * </ul>
 *
 * <p>All paths are normalized and converted to use forward slashes for consistency.
 * Only relative paths within the current directory tree are allowed.
 */
final class SafeStringPath {

    private final String value;

    /**
     * Creates a new SafePath from the given string path.
     *
     * @param migrationPath the path string to validate and sanitize
     * @throws IllegalArgumentException if the path is null, blank, contains traversal patterns, or is absolute
     */
    public SafeStringPath(final String migrationPath) {
        checkEmptyPath(migrationPath);
        checkTraversalPattern(migrationPath);
        Path path = Paths.get(migrationPath).normalize();
        checkAbsolutePath(path);
        this.value = migrationPath;
    }

    /**
     * Returns the validated path.
     *
     * @return the safe path.
     */
    public String value() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value
                .trim()
                .replace("\\", "/")
                .replaceAll("/+", "/");
    }

    private static void checkEmptyPath(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Path cannot be null");
        }

        if (path.isBlank()) {
            throw new IllegalArgumentException("Path cannot be blank");
        }
    }

    private static void checkTraversalPattern(String path) {
        if (path.contains("..")) {
            throw new IllegalArgumentException("Path contains unsafe traversal patterns: " + path);
        }
    }

    private static void checkAbsolutePath(Path path) {
        if (path.isAbsolute()) {
            throw new IllegalArgumentException("Absolute paths are not allowed: " + path);
        }
    }
}