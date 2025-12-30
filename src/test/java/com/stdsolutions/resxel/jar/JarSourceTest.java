/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.jar;

import org.junit.jupiter.api.Test;
import java.net.URL;
import java.net.URLClassLoader;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test.
 *
 * @since 0.0.27
 */
class JarSourceTest {

    @Test
    void resources() throws Exception {
        final URL jarFileUrl = Thread.currentThread()
                .getContextClassLoader()
                .getResource("jar/resxel.jar");
        String protocol = "";
        try (URLClassLoader jarClassLoader = new URLClassLoader(new URL[]{jarFileUrl}, null)) {
            final URL resource = jarClassLoader.getResource("simplelogger.properties");
            protocol = resource.getProtocol();
            System.out.println(resource.getProtocol());
        }
        assertEquals("jar", protocol);
    }
}
