package com.stdsolutions.resxel.localfs;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Source;

import java.util.stream.Stream;

public class LocalFsSource implements Source {

    private final String location;

    public LocalFsSource(final String location) {
        this.location = location;
    }

    @Override
    public Stream<Resource> stream() {
        return Stream.empty();
    }
}
