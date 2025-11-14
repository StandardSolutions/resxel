package com.stdsolutions.resxel.filesystem;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public final class Filesystem {

    private final Location location;

    public Filesystem(final String root) {
        this.location = new Location(root);
    }

    public Filesystem(final URI uri) {
        this.location = new Location(uri == null ? null : uri.toString());
    }

    public Filesystem(final URL url) {
        this.location = new Location(url == null ? null : url.toString());
    }

    public List<Path> resources() throws IOException {
        return resources(1);
    }

    public List<Path> resources(int maxDepth) throws IOException {

        try (FileSystem fs = "file".equals(location.scheme())
                ? FileSystems.getDefault()
                : FileSystems.newFileSystem(location.source())) {

            Path root = fs.getPath(location.path());
            try (Stream<Path> paths = Files.walk(root, maxDepth)) {
                return paths
                        .filter(Files::isRegularFile)
                        .toList();
            }
        }
    }
}