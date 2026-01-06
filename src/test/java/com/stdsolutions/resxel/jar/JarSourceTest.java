/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.jar;

import java.net.URL;
import java.net.URLClassLoader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * Test.
 *
 * @since 0.0.27
 */
final class JarSourceTest {

    @Test
    void resources() throws Exception {
        final URL url = Thread.currentThread()
            .getContextClassLoader()
            .getResource("jar/resxel.jar");
        final String protocol;
        try (URLClassLoader jarClassLoader = new URLClassLoader(new URL[]{url}, null)) {
            final URL resource = jarClassLoader.getResource("simplelogger.properties");
            protocol = resource.getProtocol();
        }
        MatcherAssert.assertThat(
            "Protocol should be jar",
            protocol,
            Matchers.equalTo("jar")
        );
    }
}
