package com.stdsolutions.resxel.classpath;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Filesystem;

import java.util.stream.Stream;

public class ClasspathFilesystem implements Filesystem {

    private final Filesystem[] filesystems;

    public ClasspathFilesystem(final Filesystem... filesystems) {
        this.filesystems = filesystems;
    }

    @Override
    public Stream<Resource> resources() {
        return Stream.empty();
    }
}
