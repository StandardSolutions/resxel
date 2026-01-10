/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.jarfile;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Scope;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JAR file-based scope implementation.
 *
 * @since 0.0.27
 */
public final class JarFileScope implements Scope {

    /**
     * The JAR file URI.
     */
    private final URI uri;

    /**
     * The scope path within the JAR.
     */
    private final String scope;

    /**
     * Creates a new JarFileScope.
     *
     * @param uri   The JAR file URI
     * @param scope The scope path within the JAR
     */
    public JarFileScope(final URI uri, final String scope) {
        this.uri = uri;
        this.scope = scope;
    }

    /**
     * Creates a new JarFileScope.
     *
     * @param path The path
     */
    public JarFileScope(final String path) {
        this(URI.create(path), "");
    }

    @Override
    public Set<Resource> resources() {
        return this.resources(Integer.MAX_VALUE);
    }

    @Override
    public Set<Resource> resources(final int depth) {
        Set<Resource> resources;
        try (FileSystem fs = FileSystems.newFileSystem(this.uri, Collections.emptyMap())) {
            final Path root = fs.getPath(this.scope);
            try (Stream<Path> paths = Files.walk(root, depth)) {
                resources = paths
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .map(JarFileLocation::new)
                    .map(JarFileResources::new)
                    .collect(Collectors.toSet());
            }
        } catch (final IOException ignore) {
            resources = Set.of();
        }
        return resources;
    }
}
