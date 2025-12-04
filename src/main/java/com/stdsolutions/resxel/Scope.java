package com.stdsolutions.resxel;

import java.net.URI;
import java.util.Set;

public interface Scope {

    Set<Resource> resources();

    Set<Resource> resources(int maxDepth);

    boolean contains(String filename);

    interface Type {

        String name();

        Scope toScope(String path);
    }

     interface Meta {

        String original();

        Scope scope();

        URI mount();
     }
}