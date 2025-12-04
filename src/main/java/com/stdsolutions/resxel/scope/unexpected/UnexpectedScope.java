package com.stdsolutions.resxel.scope.unexpected;

import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.Resource;

import java.util.Set;

public final class UnexpectedScope implements Scope {

    public UnexpectedScope(String s) {

    }

    @Override
    public Set<Resource> resources() {
        return Set.of();
    }

    @Override
    public Set<Resource> resources(int maxDepth) {
        return Set.of();
    }

    @Override
    public boolean contains(String filename) {
        return false;
    }
}
