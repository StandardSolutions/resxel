package com.stdsolutions.resxel.scope.file;

import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.resources.FileResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class FileScope implements Scope {

    private final String value;

    public FileScope(final String value) {
        this.value = value;
    }

    @Override
    public Set<Resource> resources() {
        return resources(Integer.MAX_VALUE);
    }

    @Override
    public Set<Resource> resources(int maxDepth) {
        try (Stream<Path> paths = Files.walk(Path.of(value), maxDepth)) {
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
    public boolean contains(String resourceName) {
        return false;
    }
}
