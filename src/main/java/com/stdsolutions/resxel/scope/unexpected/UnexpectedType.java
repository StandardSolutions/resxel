package com.stdsolutions.resxel.scope.unexpected;

import com.stdsolutions.resxel.Scope;

public class UnexpectedType implements Scope.Type {

    @Override
    public String name() {
        return "unexpected";
    }

    @Override
    public Scope toScope(String path) {
        return null;
    }
}