package com.stdsolutions.resxel;

import java.util.Set;

public interface Location {

    Set<Resource> resources();

    Set<Resource> resources(int maxDepth);

    boolean contains(String filename);
}