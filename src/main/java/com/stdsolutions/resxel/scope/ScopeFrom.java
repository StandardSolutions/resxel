package com.stdsolutions.resxel.scope;

import com.stdsolutions.resxel.Scope;
import com.stdsolutions.resxel.Scheme;
import com.stdsolutions.resxel.scope.unexpected.UnexpectedType;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class ScopeFrom {


    private final Map<String, Scope.Type> types;

    public ScopeFrom(final Collection<Scope.Type> types) {

        this.types = types.stream()
                .distinct()
                .collect(Collectors.toMap(Scope.Type::name, Function.identity()));
    }

    public Scope by(String path) {
        Scheme scheme = new Scheme(path);
        Scope.Type type = types.getOrDefault(scheme.asString(), new UnexpectedType());
        return type.toScope(path);
    }
}