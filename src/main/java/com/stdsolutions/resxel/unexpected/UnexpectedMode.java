/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.unexpected;

import com.stdsolutions.resxel.Scope;

/**
 * Unexpected mode implementation.
 *
 * @since 0.0.27
 */
public final class UnexpectedMode implements Scope.Mode {

    @Override
    public String name() {
        return "unexpected";
    }

    @Override
    public Scope scope(final String path) {
        return new UnexpectedScope(path);
    }
}
