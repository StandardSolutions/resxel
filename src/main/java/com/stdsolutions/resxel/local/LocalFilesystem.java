package com.stdsolutions.resxel.local;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Filesystem;

import java.util.stream.Stream;

public class LocalFilesystem implements Filesystem {

    private final String location;

    public LocalFilesystem(final String location) {
        this.location = location;
    }

    @Override
    public Stream<Resource> stream() {
        return Stream.empty();
    }
}
