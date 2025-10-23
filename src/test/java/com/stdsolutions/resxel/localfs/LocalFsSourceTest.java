package com.stdsolutions.resxel.localfs;

import com.stdsolutions.resxel.Resource;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class LocalFsSourceTest {

    @Test
    void stream() throws URISyntaxException, IOException {
        // Arrange
        URL resource = getClass().getClassLoader().getResource("filesystem");
        Path path = Path.of("");
        if (resource != null) {
            path = Paths.get(resource.toURI());
        }

        // Act
        LocalFsSource source = new LocalFsSource(path.toString());

        // Assert
        List<Resource> list = source.stream().toList();
        System.out.println(list);
    }
}