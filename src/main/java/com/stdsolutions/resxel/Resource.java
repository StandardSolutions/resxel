package com.stdsolutions.resxel;

/**
 * Represents a result or descriptor of a located resource object.
 * <p>
 * Resources may represent various types of data including files, database records,
 * network responses, or any other retrievable content that was identified by an origin
 * and loaded by a source.
 * </p>
 */
public interface Resource {

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
}
