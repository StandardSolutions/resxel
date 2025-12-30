/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.filesystem;

import org.junit.jupiter.api.Disabled;

/**
 * Test.
 *
 * @since 0.0.27
 */
@Disabled
class FilesystemTest {
}

//    @Test
//    void shouldReturnResourcesFromJar() throws Exception {
//         // Получаем путь к тестовому JAR файлу
////        String jarPath = Path.of(Thread.currentThread()
////                .getContextClassLoader()
////                .getResource("jar/resxel.jar")
////                .toURI()).toString();
////
////        Filesystem filesystem = new Filesystem(jarPath);
////        List<Location3> resources = filesystem.resources();
////
////        System.out.println(resources);
////        // Проверяем, что ресурсы найдены
////        assertNotNull(resources);
////        assertFalse(resources.isEmpty());
//    }
//
//    @Test
//    void shouldThrowExceptionWhenJarNotFound() {
//        String nonExistentPath = "/path/to/nonexistent.jar";
//        Filesystem filesystem = new Filesystem(nonExistentPath);
//
//        // Проверяем, что выбрасывается NoSuchFileException
//        assertThrows(NoSuchFileException.class, filesystem::resources);


//    @Test
//    void shouldReturnOnlyRegularFiles() throws Exception {
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
//    }

//    @Test
//    void testtesttest() throws Exception {
//        List<Location3> list = new ClasspathThreadSource("com").locations()
//                .map(URL::toString)
//                .map(Filesystem::new)
//                .map(fs -> {
//                    try {
//                        return fs.resources();
//                    } catch (IOException e) {
//                        return new ArrayList<Location3>();
//                    }
//                })
//                .flatMap(Collection::stream).toList();
//        System.out.println(list);
//    }
