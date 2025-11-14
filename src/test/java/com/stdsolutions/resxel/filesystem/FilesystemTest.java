package com.stdsolutions.resxel.filesystem;

import com.stdsolutions.resxel.sources.ClasspathThreadSource;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilesystemTest {

    @Test
    void shouldReturnResourcesFromJar() throws Exception {
        // Получаем путь к тестовому JAR файлу
        String jarPath = Path.of(Thread.currentThread()
                .getContextClassLoader()
                .getResource("jar/resxel.jar")
                .toURI()).toString();

        Filesystem filesystem = new Filesystem(jarPath);
        List<Path> resources = filesystem.resources();

        // Проверяем, что ресурсы найдены
        assertNotNull(resources);
        assertFalse(resources.isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenJarNotFound() {
        String nonExistentPath = "/path/to/nonexistent.jar";
        Filesystem filesystem = new Filesystem(nonExistentPath);

        // Проверяем, что выбрасывается NoSuchFileException
        assertThrows(NoSuchFileException.class, filesystem::resources);
    }

    @Test
    void shouldReturnOnlyRegularFiles() throws Exception {
        String jarPath = Path.of(Thread.currentThread()
                .getContextClassLoader()
                .getResource("jar/resxel.jar")
                .toURI()).toString();

        Filesystem filesystem = new Filesystem(jarPath);
        List<Path> resources = filesystem.resources();
        resources.stream().forEach(System.out::println);
        // Проверяем, что все элементы - это файлы (не директории)
        assertTrue(resources.stream().allMatch(path -> !path.toString().endsWith("/")));
    }

    @Test
    void testtesttest() throws Exception {
        new ClasspathThreadSource("jar").resources()
                .map(URL::toString)
                .map(Filesystem::new)
                .map(fs -> {
                    try {
                        return fs.resources();
                    } catch (IOException e) {
                        return new ArrayList<Path>();
                    }
                })
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }
}