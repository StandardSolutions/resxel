package com.stdsolutions.resxel;

/**
 * Represents a result or descriptor of a located resource object.
 * <p>
 * A {@code Resource} is the outcome of a {@link Source} reading from an {@link Origin}.
 * It serves as either the actual retrieved data or a handle/descriptor that provides
 * access to the underlying resource content.
 * </p>
 * <p>
 * Implementations may provide direct access to the resource data, lazy-loading mechanisms,
 * metadata about the resource, or streaming capabilities depending on the resource type
 * and size considerations.
 * </p>
 * <p>
 * Resources may represent various types of data including files, database records,
 * network responses, or any other retrievable content that was identified by an origin
 * and loaded by a source.
 * </p>
 *
 * @see Origin
 * @see Source
 */
public interface Resource {

    /**
     * Returns the origin from which this resource was retrieved.
     *
     * @return the origin descriptor, never {@code null}
     */
    Origin getOrigin();

    /**
     * Returns the content of this resource as a byte array.
     * <p>
     * This method loads the entire resource into memory. For large resources,
     * consider using {@link #getInputStream()} instead.
     * </p>
     *
     * @return the resource content as bytes, never {@code null}
     * @throws java.io.IOException if an error occurs reading the content
     */
    byte[] getContent() throws java.io.IOException;

    /**
     * Returns an input stream for reading the resource content.
     * <p>
     * The caller is responsible for closing the returned stream.
     * </p>
     *
     * @return an input stream for the resource content, never {@code null}
     * @throws java.io.IOException if an error occurs opening the stream
     */
    java.io.InputStream getInputStream() throws java.io.IOException;

    /**
     * Returns the size of this resource in bytes.
     *
     * @return the resource size, or {@code -1} if the size is unknown
     * @throws java.io.IOException if an error occurs determining the size
     */
    long getSize() throws java.io.IOException;

    /**
     * Returns the content type (MIME type) of this resource.
     *
     * @return the content type, or {@code null} if unknown
     */
    String getContentType();

    /**
     * Returns the timestamp when this resource was last modified.
     *
     * @return the last modification timestamp, or {@code null} if unknown
     */
    java.time.Instant getLastModified();

    /**
     * Returns metadata or attributes associated with this resource.
     * <p>
     * This may include file attributes, HTTP headers, database column metadata,
     * or any other contextual information about the resource.
     * </p>
     *
     * @return a map of metadata properties, may be empty but never {@code null}
     */
    java.util.Map<String, Object> getAttributes();

    /**
     * Checks whether this resource currently exists and is accessible.
     * <p>
     * Resources may become unavailable after initial retrieval due to deletion,
     * network issues, or permission changes.
     * </p>
     *
     * @return {@code true} if the resource exists and is accessible, {@code false} otherwise
     */
    boolean exists();
}
