package com.stdsolutions.resxel;

import com.stdsolutions.resxel.unexpected.UnexpectedMode;

import java.net.URL;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class ScopeFrom {


    private final Map<String, Scope.Mode> modes;

    public ScopeFrom(final Collection<Scope.Mode> modes) {

        this.modes = modes.stream()
                .distinct()
                .collect(Collectors.toMap(Scope.Mode::name, Function.identity()));
    }

    public Scope by(String path) {
        Scheme scheme = new Scheme(path);
        Scope.Mode mode = modes.getOrDefault(scheme.asString(), new UnexpectedMode());
        return mode.scope(path);
    }

    public Scope by(URL url) {
        return by(String.valueOf(url));
    }
}