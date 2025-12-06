package com.stdsolutions.resxel.jarfile;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Scope;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class JarFileScope implements Scope {

    private final URI uri;

    private final String scope;

    public JarFileScope(final URI uri, final String scope) {
        this.uri = uri;
        this.scope = scope;
    }

    public JarFileScope(final String path) {
        this.uri = null;
        this.scope = null;
    }

    @Override
    public Set<Resource> resources() {
        return resources(Integer.MAX_VALUE);
    }

    @Override
    public Set<Resource> resources(int maxDepth) {
        try (FileSystem fs = FileSystems.newFileSystem(uri, Collections.emptyMap())) {
            Path root = fs.getPath(scope);
            try (Stream<Path> paths = Files.walk(root, maxDepth)) {
                return paths
                        .filter(Files::isRegularFile)
                        .map(Path::toString)
                        .map(JarFileLocation::new)
                        .map(JarFileResources::new)
                        .collect(Collectors.toSet());
            }

        } catch (IOException e) {
            return Set.of();
        }
    }
}
