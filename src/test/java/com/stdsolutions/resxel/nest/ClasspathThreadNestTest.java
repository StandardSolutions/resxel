/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Merkurev Sergei
 * SPDX-License-Identifier: Apache-2.0
 */
package com.stdsolutions.resxel.nest;

import com.stdsolutions.resxel.Scope;
import java.util.Collection;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * Test.
 *
 * @since 0.0.27
 */
final class ClasspathThreadNestTest {

    @Test
    void locations() throws Exception {
        final ClasspathThreadNest source = new ClasspathThreadNest("com");
        final Collection<Scope> resources = source.scopes();
        MatcherAssert.assertThat(
            "Resources should not be null",
            resources,
            Matchers.notNullValue()
        );
    }
}
