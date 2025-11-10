package com.stdsolutions.resxel.filesystems;

import com.stdsolutions.resxel.Source;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.resources.FileResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class LocalFilesystem implements Source {

    private final String path;

    public LocalFilesystem(final String path) {
        this.path = path;
    }

    @Override
    public Stream<Resource> resources() {
        Path rootPath = Paths.get(path.toString());

        try (Stream<Path> paths = Files.walk(rootPath, 1)) {
            return paths
                    .filter(Files::isRegularFile)
                    .<Resource>map(FileResource::new)
                    .toList()
                    .stream();
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}