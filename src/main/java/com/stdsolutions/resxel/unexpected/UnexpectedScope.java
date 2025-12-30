/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.unexpected;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Scope;
import java.util.Set;

/**
 * Represents an unexpected scope that implements Scope.
 *
 * <p>This class returns empty resources.</p>
 *
 * @since 0.0.27
 */
public final class UnexpectedScope implements Scope {

    public UnexpectedScope(final String s) {
    }

    @Override
    public Set<Resource> resources() {
        return Set.of();
    }

    @Override
    public Set<Resource> resources(final int maxDepth) {
        return Set.of();
    }
}
