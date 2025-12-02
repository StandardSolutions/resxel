package com.stdsolutions.resxel.sources;

import com.stdsolutions.resxel.Location;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClasspathThreadNestTest {

    @Test
    void locations() throws Exception {
        ClasspathThreadNest source = new ClasspathThreadNest("com");
        Collection<Location> resources = source.locations();

        System.out.println(resources);
        assertNotNull(resources);
    }
}