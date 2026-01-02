/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.shared;

/**
 * Functional interface for suppliers that may throw exceptions.
 *
 * @param <T> the type of results supplied by this supplier
 * @since 0.0.27
 */
@FunctionalInterface
public interface CheckedSupplier<T> {
    /**
     * Gets a result.
     *
     * @return A result
     * @throws Exception if unable to get result
     */
    T get() throws Exception;
}
