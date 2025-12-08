package com.stdsolutions.resxel.shared;

import java.util.Objects;

public sealed interface Result<T> permits Result.Ok, Result.Err {

    static <T> Result<T> ok(T value) {
        return new Ok<>(Objects.requireNonNull(value));
    }

    static <T> Result<T> err(Throwable cause) {
        return new Err<>(Objects.requireNonNull(cause));
    }

    static <T> Result<T> tryCatch(CheckedSupplier<? extends T> supplier) {
        try {
            return ok(supplier.get());
        } catch (Exception ex) {
            return err(ex);
        }
    }

    record Ok<T>(T value) implements Result<T> {

    }

    record Err<T>(Throwable cause) implements Result<T> {
        public Err {
            Objects.requireNonNull(cause);
        }
    }
}