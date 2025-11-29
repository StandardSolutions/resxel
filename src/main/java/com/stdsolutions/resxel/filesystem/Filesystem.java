package com.stdsolutions.resxel.filesystem;

import com.stdsolutions.resxel.Location3;
import com.stdsolutions.resxel.location.Location3Of;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class Filesystem {

    private final Location3 location3;

    public Filesystem(final String root) {
        this.location3 = new Location3Of(root);
    }

    public Filesystem(final URI uri) {
        this.location3 = new Location3Of(uri == null ? null : uri.toString());
    }

    public Filesystem(final URL url) {
        this.location3 = new Location3Of(url == null ? null : url.toString());
    }

    public List<Location3> resources() throws IOException {
        return resources(Integer.MAX_VALUE);
    }

    public List<Location3> resources(int maxDepth) throws IOException {
        FileSystem fs = "file".equals(location3.scheme())
                ? FileSystems.getDefault()
                : FileSystems.newFileSystem(location3.source(), Collections.emptyMap());
        boolean shouldClose = fs != FileSystems.getDefault();

        Path root = fs.getPath(location3.path());
        try (Stream<Path> paths = Files.walk(root, maxDepth)) {
            return paths
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .map(Location3Of::new)
                    .map(l -> (Location3) l)
                    .toList();
        } finally {
            if (shouldClose) {
                fs.close();
            }
        }
    }
}