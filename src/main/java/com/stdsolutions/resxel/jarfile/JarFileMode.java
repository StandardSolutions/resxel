/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.jarfile;

import com.stdsolutions.resxel.Scope;

/**
 * JAR file-based scope mode implementation.
 *
 * @since 0.0.27
 */
public final class JarFileMode implements Scope.Mode {

    @Override
    public String name() {
        return "jar:file";
    }

    @Override
    public Scope scope(final String path) {
        return new JarFileScope(path);
    }
}
