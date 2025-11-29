package com.stdsolutions.resxel.jar;

import com.stdsolutions.resxel.Location;
import com.stdsolutions.resxel.Scope;

import java.net.URI;

public class JarScope implements Scope {

    private final String scope;

    public JarScope(String scope) {
        this.scope = scope;
    }

    @Override
    public Location in(String bin) {
        return new JarLocation(URI.create(""), scope);
    }
}
