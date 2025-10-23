package com.stdsolutions.resxel.filesystem;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Source;

import java.util.stream.Stream;

public class FilesystemSource implements Source {

    public FilesystemSource(String s) {

    }

    @Override
    public Stream<Resource> stream() {
        return Stream.empty();
    }
}
