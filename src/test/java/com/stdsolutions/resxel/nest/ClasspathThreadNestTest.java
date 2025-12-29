package com.stdsolutions.resxel.nest;

import com.stdsolutions.resxel.Scope;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClasspathThreadNestTest {

    @Test
    void locations() throws Exception {
        final ClasspathThreadNest source = new ClasspathThreadNest("com");
        final Collection<Scope> resources = source.scopes();
        System.out.println(resources);
        assertNotNull(resources);
    }
}
