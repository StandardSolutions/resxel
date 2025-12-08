package com.stdsolutions.resxel.shared;

@FunctionalInterface
public interface CheckedSupplier<T> {
    T get() throws Exception;
}