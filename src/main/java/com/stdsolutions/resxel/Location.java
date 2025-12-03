package com.stdsolutions.resxel;

import java.net.URI;
import java.util.Set;

public interface Location {

    Set<Resource> resources();

    Set<Resource> resources(int maxDepth);

    boolean contains(String filename);

    interface Type {

        boolean support(String path);

        Location toLocation(String path);
    }

     interface Meta {

        String original();

        Scope scope();

        URI mount();
     }
}