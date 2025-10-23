package com.stdsolutions.resxel.classpath;

import com.stdsolutions.resxel.filesystem.FilesystemSource;
import com.stdsolutions.resxel.jar.JarSource;
import org.junit.jupiter.api.Test;

class ClasspathSourceTest {

    @Test
    void testClasspathSource() {
        new ClasspathSource(
                new FilesystemSource("/migrations"),
                new JarSource("/migr/test"));
    }

}