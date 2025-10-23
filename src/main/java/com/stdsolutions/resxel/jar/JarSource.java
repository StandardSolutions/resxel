package com.stdsolutions.resxel.jar;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Source;

import java.util.stream.Stream;

public class JarSource implements Source {

    public JarSource(String path) {
    }

    @Override
    public Stream<Resource> stream() {
        return Stream.empty();
    }
}
