package com.stdsolutions.resxel.file;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Scope;

import java.net.URI;

public class FileScope implements Scope {

    private final String scope;

    public FileScope(String scope) {
        this.scope = scope;
    }

    @Override
    public Location in(String bin) {
        return new FileLocation(URI.create(""), scope);
    }
}
