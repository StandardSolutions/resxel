package com.stdsolutions.resxel.filesystems;

import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JarFilesystemTest {

    @Test
    void shouldReturnResourcesFromJar() throws Exception {
        // Получаем путь к тестовому JAR файлу
        String jarPath = Path.of(Thread.currentThread()
                .getContextClassLoader()
                .getResource("jar/resxel.jar")
                .toURI()).toString();

        JarFilesystem jarFilesystem = new JarFilesystem(jarPath);
        List<Path> resources = jarFilesystem.resources();

        // Проверяем, что ресурсы найдены
        assertNotNull(resources);
        assertFalse(resources.isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenJarNotFound() {
        String nonExistentPath = "/path/to/nonexistent.jar";
        JarFilesystem jarFilesystem = new JarFilesystem(nonExistentPath);

        // Проверяем, что выбрасывается NoSuchFileException
        assertThrows(NoSuchFileException.class, jarFilesystem::resources);
    }

    @Test
    void shouldReturnOnlyRegularFiles() throws Exception {
        String jarPath = Path.of(Thread.currentThread()
                .getContextClassLoader()
                .getResource("jar/resxel.jar")
                .toURI()).toString();

        JarFilesystem jarFilesystem = new JarFilesystem(jarPath);
        List<Path> resources = jarFilesystem.resources();
        resources.stream().forEach(System.out::println);
        // Проверяем, что все элементы - это файлы (не директории)
        assertTrue(resources.stream().allMatch(path -> !path.toString().endsWith("/")));
    }
}