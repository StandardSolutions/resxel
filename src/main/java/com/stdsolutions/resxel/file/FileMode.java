/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Scope;

/**
 * File-based scope mode implementation.
 *
 * @since 0.0.27
 */
public final class FileMode implements Scope.Mode {

    @Override
    public String name() {
        return "file";
    }

    @Override
    public Scope scope(final String path) {
        return new FileScope(path);
    }
}
