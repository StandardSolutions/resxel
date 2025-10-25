package com.stdsolutions.resxel.jar;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.net.URLClassLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JarFilesystemTest {

    @Test
    void stream() throws Exception {
        URL jarFileUrl = Thread.currentThread().getContextClassLoader().getResource("jar/resxel.jar");

        String protocol = "";
        try (URLClassLoader jarClassLoader = new URLClassLoader(new URL[]{jarFileUrl}, null)) {
            URL resource = jarClassLoader.getResource("simplelogger.properties");
            protocol = resource.getProtocol();
            System.out.println(resource.getProtocol());
        }
        assertEquals("jar", protocol);
    }
}