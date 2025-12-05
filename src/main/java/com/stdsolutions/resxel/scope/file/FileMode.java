package com.stdsolutions.resxel.scope.file;

import com.stdsolutions.resxel.Scope;

public final class FileMode implements Scope.Mode {

    @Override
    public String name() {
        return "file";
    }

    @Override
    public Scope scope(String path) {
        return new FileScope(path);
    }
}