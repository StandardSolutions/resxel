package com.stdsolutions.resxel.scope;

import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.Scheme;
import com.stdsolutions.resxel.scope.unexpected.UnexpectedMode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class ScopeFrom {


    private final Map<String, Scope.Mode> types;

    public ScopeFrom(final Collection<Scope.Mode> modes) {

        this.types = modes.stream()
                .distinct()
                .collect(Collectors.toMap(Scope.Mode::name, Function.identity()));
    }

    public Scope by(String path) {
        Scheme scheme = new Scheme(path);
        Scope.Mode mode = types.getOrDefault(scheme.asString(), new UnexpectedMode());
        return mode.scope(path);
    }
}