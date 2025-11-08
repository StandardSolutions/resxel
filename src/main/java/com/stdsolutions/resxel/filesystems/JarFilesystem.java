package com.stdsolutions.resxel.filesystems;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public final class JarFilesystem {

    private final String path;

    public JarFilesystem(final String path) {
        this.path = path;
    }

    public List<Path> resources() throws IOException {
            return resources(1);
    }

    public List<Path> resources(int maxDepth) throws IOException {
        Path jarPath = Path.of(path);
        if (!Files.exists(jarPath)) {
            throw new NoSuchFileException("JAR file not found: " + jarPath);
        }
        try (FileSystem fs = FileSystems.newFileSystem(jarPath)) {
            Path root = fs.getPath("/");
            try (var paths = Files.walk(root, maxDepth)) {
                return paths
                        .filter(Files::isRegularFile)
                        .toList();
            }
        }
    }
}