/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Scope;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * File-based scope implementation.
 *
 * @since 0.0.27
 */
final class FileScope implements Scope {

    /**
     * The directory path.
     */
    private final String value;

    /**
     * Creates a new FileScope.
     *
     * @param value The directory path
     */
    FileScope(final String value) {
        this.value = value;
    }

    @Override
    public Set<Resource> resources() {
        return resources(Integer.MAX_VALUE);
    }

    @Override
    public Set<Resource> resources(final int maxDepth) {
        try (Stream<Path> paths = Files.walk(Path.of(value), maxDepth)) {
            return paths.filter(Files::isRegularFile)
                .map(Path::toString)
                .map(FileLocation::new)
                .map(FileResource::new)
                .collect(Collectors.toSet());
        } catch (IOException e) {
            return Set.of();
        }
    }
}
