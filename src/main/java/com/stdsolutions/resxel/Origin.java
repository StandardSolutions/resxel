package com.stdsolutions.resxel;

/**
 * Represents the origin of a resource - a passive data transfer object (DTO) that describes
 * where and what to search for.
 * <p>
 * An {@code Origin} encapsulates the metadata and location information needed to identify
 * and retrieve a resource. It acts as a descriptor that provides all necessary details
 * for a {@link Source} to locate and read the target resource.
 * </p>
 * <p>
 * Typical implementations might include file paths, URLs, database connection details,
 * or any other location identifiers along with search criteria or filters.
 * </p>
 *
 * @see Source
 * @see Resource
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
    String getLocation();

    /**
     * Returns the type or scheme of this origin.
     * <p>
     * Examples include "file", "http", "jdbc", "classpath", etc.
     * This helps sources determine how to handle the origin.
     * </p>
     *
     * @return the origin type/scheme, never {@code null}
     */
    String getType();

    /**
     * Returns additional metadata or properties associated with this origin.
     * <p>
     * This may include search criteria, filters, authentication credentials,
     * or any other configuration needed to locate and access the resource.
     * </p>
     *
     * @return a map of metadata properties, may be empty but never {@code null}
     */
    java.util.Map<String, Object> getMetadata();

    /**
     * Returns a human-readable description of this origin.
     *
     * @return a description of this origin, may be {@code null}
     */
    String getDescription();
}
