package com.stdsolutions.resxel.jar;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Filesystem;

import java.util.stream.Stream;

public class JarFilesystem implements Filesystem {

    public JarFilesystem(String path) {
    }

    @Override
    public Stream<Resource> stream() {
        return Stream.empty();
    }
}
