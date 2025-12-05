package com.stdsolutions.resxel.scope.unexpected;

import com.stdsolutions.resxel.Scope;

public final class UnexpectedMode implements Scope.Mode {

    @Override
    public String name() {
        return "unexpected";
    }

    @Override
    public Scope scope(String path) {
        return new UnexpectedScope(path);
    }
}