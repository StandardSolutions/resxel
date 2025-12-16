package com.stdsolutions.resxel.unexpected;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Scope;
import java.util.Set;

public final class UnexpectedScope implements Scope {

    public UnexpectedScope(final String s) {

    }

    @Override
    public Set<Resource> resources() {
        return Set.of();
    }

    @Override
    public Set<Resource> resources(final int maxDepth) {
        return Set.of();
    }
}