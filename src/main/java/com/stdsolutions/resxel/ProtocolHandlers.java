package com.stdsolutions.resxel;

import java.net.URL;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public final class ProtocolHandlers {

    private final Map<String, Function<URL, Resource>> supported;

    public ProtocolHandlers(final String protocol1, final Function<URL, Resource> function1) {
        this.supported = Map.of(protocol1, function1);
    }

    public ProtocolHandlers(final String protocol1, final Function<URL, Resource> function1,
                            final String protocol2, final Function<URL, Resource> function2) {
        this.supported = Map.of(
                protocol1, function1,
                protocol2, function2
        );
    }

    public Optional<Resource> handle(URL url) {
        String protocol = url.getProtocol();
        Function<URL, Resource> handler = supported.get(protocol);
        if (handler == null) {
            return Optional.empty();
        }
        return Optional.of(handler.apply(url));
    }
}
