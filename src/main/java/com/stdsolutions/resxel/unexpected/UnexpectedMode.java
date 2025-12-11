package com.stdsolutions.resxel.unexpected;

import com.stdsolutions.resxel.Scope;

public final class UnexpectedMode implements Scope.Mode {

    @Override
    public String name() {
        return "unexpected";
    }

    @Override
    public Scope scope(final String path) {
        return new UnexpectedScope(path);
    }
}