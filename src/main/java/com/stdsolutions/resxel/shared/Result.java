/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.shared;

import java.util.Objects;

/**
 * Result type for operations that may succeed or fail.
 *
 * @param <T> the type of the success value
 * @since 0.0.27
 */
public sealed interface Result<T> permits Result.Success, Result.Err {

    /**
     * Creates a successful result.
     *
     * @param value The success value
     * @param <T> the type of the value
     * @return The result
     */
    static <T> Result<T> success(final T value) {
        return new Success<>(Objects.requireNonNull(value));
    }

    /**
     * Creates a failed result.
     *
     * @param cause The error cause
     * @param <T> the type of the value
     * @return The result
     */
    static <T> Result<T> err(final Throwable cause) {
        return new Err<>(Objects.requireNonNull(cause));
    }

    /**
     * Executes the supplier and wraps result.
     *
     * @param supplier The supplier
     * @param <T> the type of the value
     * @return The result
     */
    static <T> Result<T> tryCatch(final CheckedSupplier<? extends T> supplier) {
        try {
            return success(supplier.get());
        } catch (final Exception ex) {
            return err(ex);
        }
    }

    /**
     * Successful result record.
     *
     * @param value The success value
     * @param <T> the type of the value
     * @since 0.0.27
     */
    record Success<T>(T value) implements Result<T> {

    }

    /**
     * Failed result record.
     *
     * @param cause The error cause
     * @param <T> the type of the value
     * @since 0.0.27
     */
    record Err<T>(Throwable cause) implements Result<T> {
        /**
         * Compact constructor.
         *
         * @param cause The error cause
         */
        public Err {
            Objects.requireNonNull(cause);
        }
    }
}
