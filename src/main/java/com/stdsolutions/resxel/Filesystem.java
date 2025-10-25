package com.stdsolutions.resxel;

import java.util.stream.Stream;

/**
 * Retrieves resources based on their origins.
 */
public interface Filesystem {

//    /**
//     * Reads and retrieves a resource from the specified origin.
//     */
//    Resource read(Origin origin);

    Stream<Resource> stream();
}
