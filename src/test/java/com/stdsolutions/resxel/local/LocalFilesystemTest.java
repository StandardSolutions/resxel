package com.stdsolutions.resxel.local;

import com.stdsolutions.resxel.Resource;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class LocalFilesystemTest {

    @Test
    void stream() throws URISyntaxException, IOException {
        // Arrange
        URL resource = getClass().getClassLoader().getResource("local");
        Path path = Path.of("");
        if (resource != null) {
            path = Paths.get(resource.toURI());
        }

        // Act
        LocalFilesystem source = new LocalFilesystem(path.toString());

        // Assert
        List<Resource> list = source.stream().toList();
        System.out.println(list);
    }
}