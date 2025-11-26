package com.stdsolutions.resxel.filesystem;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.location.LocationOf;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public final class Filesystem {

    private final LocationOf locationOf;

    public Filesystem(final String root) {
        this.locationOf = new LocationOf(root);
    }

    public Filesystem(final URI uri) {
        this.locationOf = new LocationOf(uri == null ? null : uri.toString());
    }

    public Filesystem(final URL url) {
        this.locationOf = new LocationOf(url == null ? null : url.toString());
    }

    public List<Location> resources() throws IOException {
        return resources(10);
    }

    public List<Location> resources(int maxDepth) throws IOException {
        String substring = locationOf.source().toString();
        if ("jar:file".equals(locationOf.scheme())) {
            substring = substring.substring(9);
        }

        FileSystem fs = "file".equals(locationOf.scheme())
                ? FileSystems.getDefault()
                : FileSystems.newFileSystem(Path.of(substring), Collections.emptyMap());
        boolean shouldClose = fs != FileSystems.getDefault();

        Path root = fs.getPath(locationOf.path());
        try (Stream<Path> paths = Files.walk(root, maxDepth)) {
            return paths
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .map(LocationOf::new)
                    .map(l -> (Location) l)
                    .toList();
        } finally {
            if (shouldClose) {
                fs.close();
            }
        }
    }
}