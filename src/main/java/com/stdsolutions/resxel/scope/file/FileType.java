package com.stdsolutions.resxel.scope.file;

import com.stdsolutions.resxel.Scope;

public class FileType implements Scope.Type {

    @Override
    public String name() {
        return "file";
    }

    @Override
    public Scope toScope(String path) {
        return null;
    }
}