package com.stdsolutions.resxel;

import java.util.Arrays;
import java.util.stream.Stream;

public class ResXeL {

    private final Source[] sources;

    public ResXeL(final Source... sources) {
        this.sources = sources;
    }

    public Stream<Resource> stream() {
        return Arrays.stream(sources).flatMap(Source::stream);
    }
}