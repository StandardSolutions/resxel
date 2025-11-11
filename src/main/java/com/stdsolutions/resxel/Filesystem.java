package com.stdsolutions.resxel;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class Filesystem {

    private final Location location;

    public Filesystem(final Location location) {
        this.location = location;
    }

    public Filesystem(final String root) {
        this(new Location(root, "/"));
    }

    public List<Path> resources() throws IOException {
        return resources(1);
    }

    public List<Path> resources(int maxDepth) throws IOException {
        try (FileSystem fs = FileSystems.newFileSystem(location.root())) {
            Path root = fs.getPath(location.dir());
            try (var paths = Files.walk(root, maxDepth)) {
                return paths
                        .filter(Files::isRegularFile)
                        .toList();
            }
        }
    }
}