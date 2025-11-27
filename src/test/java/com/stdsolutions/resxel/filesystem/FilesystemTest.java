package com.stdsolutions.resxel.filesystem;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.sources.ClasspathThreadSource;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class FilesystemTest {

    @Test
    void shouldReturnResourcesFromJar() throws Exception {
         // Получаем путь к тестовому JAR файлу
        String jarPath = Path.of(Thread.currentThread()
                .getContextClassLoader()
                .getResource("jar/resxel.jar")
                .toURI()).toString();

        Filesystem filesystem = new Filesystem(jarPath);
        List<Location> resources = filesystem.resources();

        System.out.println(resources);
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
//        String jarPath = Path.of(Thread.currentThread()
//                .getContextClassLoader()
//                .getResource("jar/resxel.jar")
//                .toURI()).toString();
//
//        Filesystem filesystem = new Filesystem(jarPath);
//        List<Path> resources = filesystem.resources();
//        resources.stream().forEach(System.out::println);
//        // Проверяем, что все элементы - это файлы (не директории)
//        assertTrue(resources.stream().allMatch(path -> !path.toString().endsWith("/")));
    }

    @Test
    void testtesttest() throws Exception {
        List<Location> list = new ClasspathThreadSource("com").resources()
                .map(URL::toString)
                .map(Filesystem::new)
                .map(fs -> {
                    try {
                        return fs.resources();
                    } catch (IOException e) {
                        return new ArrayList<Location>();
                    }
                })
                .flatMap(Collection::stream).toList();
        System.out.println(list);
    }

}