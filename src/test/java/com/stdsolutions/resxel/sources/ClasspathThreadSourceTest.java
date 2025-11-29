package com.stdsolutions.resxel.sources;

import com.stdsolutions.resxel.Location;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClasspathThreadSourceTest {

    @Test
    void locations() throws Exception {
        ClasspathThreadSource source = new ClasspathThreadSource("com");
        Collection<Location> resources = source.locations();

        System.out.println(resources);
        assertNotNull(resources);
    }
}