package com.stdsolutions.resxel;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Retrieves resources based on their origins.
 */
public interface Source {

//    /**
//     * Reads and retrieves a resource from the specified origin.
//     */
//    Resource read(Origin origin);

    Stream<Resource> resources() throws IOException;
}
