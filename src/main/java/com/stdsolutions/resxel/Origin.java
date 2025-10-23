package com.stdsolutions.resxel;

/**
 * Represents the origin of a resource that describes where and what to search for.
 */
public interface Origin {

    /**
     * Returns the location identifier of this origin.
     * <p>
     * The location can be a file path, URL, database identifier, or any other
     * address that points to where the resource can be found.
     * </p>
     *
     * @return the location identifier, never {@code null}
     */
    String location();

    /**
     * Returns the type or scheme of this origin.
     * <p>
     * Examples include "file", "http", "jdbc", "classpath", etc.
     * This helps sources determine how to handle the origin.
     * </p>
     *
     * @return the origin type/scheme, never {@code null}
     */
    String type();

    /**
     * Provides a human-readable description of this origin.
     * <p>
     * Intended mainly for logging or debugging. By default, combines type and location.
     * </p>
     *
     * @return the descriptive string of this origin, never {@code null}
     */
    default String description() {
        return type() + ":" + location();
    }

    final class Default {

        private final String location;

        private final String type;

        public Default(String location, String type) {
            this.location = location;
            this.type = type;
        }
    }
}