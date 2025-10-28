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

        Stream<Resource> localResources;
        try {
            localResources = Files.walk(rootPath, 1)
                    .filter(Files::isRegularFile)
                    .map(LocalFsResource::new);
        } catch (IOException e) {
            localResources = Stream.empty();
        }

        return Stream.concat(localResources, Stream.empty());
    }
}