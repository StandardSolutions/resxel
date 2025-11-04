package com.stdsolutions.resxel.local;

import com.stdsolutions.resxel.Resources;
import com.stdsolutions.resxel.ResPath;
import com.stdsolutions.resxel.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LocalResources implements Resources {

    private final ResPath path;

    public LocalResources(final ResPath path) {
        this.path = path;
    }

    @Override
    public Stream<Resource> resources() {
        Path rootPath = Paths.get(path.toString());

        try (Stream<Path> paths = Files.walk(rootPath, 1)) {
            return paths
                    .filter(Files::isRegularFile)
                    .<Resource>map(LocalFsResource::new)
                    .toList()
                    .stream();
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}