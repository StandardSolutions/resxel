package com.stdsolutions.resxel.classpath;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Source;

import java.util.stream.Stream;

public class ClasspathSource implements Source {

    private final Source[] sources;

    public ClasspathSource(final Source... sources) {
        this.sources = sources;
    }

    @Override
    public Stream<Resource> stream() {
        return Stream.empty();
    }
}
