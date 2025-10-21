package com.stdsolutions.resxel;

/**
 * Represents an active reader or service that retrieves resources based on their origins.
 * <p>
 * A {@code Source} is responsible for reading and resolving {@link Resource} objects
 * from given {@link Origin} descriptors. It encapsulates the logic and mechanisms
 * required to access, parse, and transform origin data into usable resources.
 * </p>
 * <p>
 * Implementations of this interface handle the actual I/O operations, data retrieval,
 * and resource instantiation. Different source types might read from file systems,
 * networks, databases, or other data repositories.
 * </p>
 * <p>
 * Example usage:
 * <pre>{@code
 * Origin origin = ...; // Create an origin descriptor
 * Source source = ...; // Obtain a source implementation
 * Resource resource = source.read(origin); // Retrieve the resource
 * }</pre>
 * </p>
 *
 * @see Origin
 * @see Resource
 */
public interface Source {

    /**
     * Reads and retrieves a resource from the specified origin.
     * <p>
     * This method performs the actual retrieval operation, accessing the location
     * described by the origin and creating a resource object.
     * </p>
     *
     * @param origin the origin descriptor specifying where and what to retrieve
     * @return the retrieved resource, never {@code null}
     * @throws ResourceNotFoundException if the resource cannot be found at the origin
     * @throws ResourceAccessException if the resource exists but cannot be accessed
     */
    Resource read(Origin origin);

    /**
     * Checks whether a resource exists at the specified origin without fully reading it.
     *
     * @param origin the origin to check
     * @return {@code true} if a resource exists at the origin, {@code false} otherwise
     */
    boolean exists(Origin origin);

    /**
     * Determines whether this source supports the given origin type.
     * <p>
     * Sources may only handle specific origin types (e.g., file-based, HTTP-based).
     * </p>
     *
     * @param origin the origin to check for support
     * @return {@code true} if this source can handle the origin, {@code false} otherwise
     */
    boolean supports(Origin origin);

    /**
     * Reads multiple resources from the specified origins.
     * <p>
     * This method allows batch retrieval, which may be optimized by implementations.
     * </p>
     *
     * @param origins the collection of origins to read from
     * @return a list of resources corresponding to the origins
     * @throws ResourceNotFoundException if any resource cannot be found
     */
    java.util.List<Resource> readAll(java.util.Collection<Origin> origins);

    /**
     * Closes this source and releases any underlying resources or connections.
     * <p>
     * After calling this method, the source should not be used for further operations.
     * </p>
     *
     * @throws Exception if an error occurs during closing
     */
    void close() throws Exception;
}
