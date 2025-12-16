package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Scope;

public final class FileMode implements Scope.Mode {

    @Override
    public String name() {
        return "file";
    }

    @Override
    public Scope scope(final String path) {
        return new FileScope(path);
    }
}
