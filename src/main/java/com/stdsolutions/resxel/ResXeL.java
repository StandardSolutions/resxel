package com.stdsolutions.resxel;

import java.util.Arrays;
import java.util.stream.Stream;

public final class ResXeL {

    private final Filesystem[] filesystems;

    public ResXeL(final Filesystem... filesystems) {
        this.filesystems = filesystems;
    }

    public Stream<Resource> stream() {
        return Arrays.stream(filesystems).flatMap(Filesystem::stream);
    }
}