package com.stdsolutions.resxel.classpath;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.localfs.LocalFsSource;
import com.stdsolutions.resxel.jar.JarSource;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class ClasspathSourceTest {

    @Test
    void testClasspathSource() {
        ClasspathSource source = new ClasspathSource(
                new LocalFsSource("/migrations"),
                new JarSource("/migr/test")
        );

        Stream<Resource> stream = source.stream();
    }

}