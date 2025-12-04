package com.stdsolutions.resxel.scope.jarfile;

import com.stdsolutions.resxel.Scope;

public class JarFileType implements Scope.Type {

    @Override
    public String name() {
        return "jar:file";
    }

    @Override
    public Scope toScope(String path) {
        return null;
    }
}