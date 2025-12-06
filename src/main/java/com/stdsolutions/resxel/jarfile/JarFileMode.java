package com.stdsolutions.resxel.jarfile;

import com.stdsolutions.resxel.Scope;

public final class JarFileMode implements Scope.Mode {

    @Override
    public String name() {
        return "jar:file";
    }

    @Override
    public Scope scope(String path) {
        return new JarFileScope(path);
    }
}