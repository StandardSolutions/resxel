package com.stdsolutions.resxel;

import com.stdsolutions.resxel.shared.Result;

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
     * consider using {@link #inputStream()} instead.
     * </p>
     *
     * @return the resource content as bytes, never {@code null}
     */
    Result<byte[]> asBytes();

    Result<String> asString();

    Location location();
}
