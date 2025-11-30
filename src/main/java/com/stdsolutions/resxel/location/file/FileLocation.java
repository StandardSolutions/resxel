package com.stdsolutions.resxel.location.file;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.resources.FileResource;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class FileLocation implements Location {

    private final URI uri;

    private final String scope;

    public FileLocation(final URI uri, final String scope) {
        this.uri = uri;
        this.scope = scope;
    }

    public FileLocation(final String path) {
        this.uri = null;
        this.scope = null;
    }

    @Override
    public Set<Resource> resources() {
        return resources(Integer.MAX_VALUE);
    }

    @Override
    public Set<Resource> resources(int maxDepth) {
        try (Stream<Path> paths = Files.walk(Path.of(scope), maxDepth)) {
            return paths
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .map(FileResource::new)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            return Set.of();
        }
    }

    @Override
    public boolean contains(String filename) {
        return false;
    }
}
