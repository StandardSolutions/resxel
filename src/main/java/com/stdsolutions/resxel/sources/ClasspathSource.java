package com.stdsolutions.resxel.sources;

import com.stdsolutions.resxel.ProtocolHandlers;
import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Source;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ClasspathSource implements Source {

    private final String path;

    private final List<Resource> resources;

    private final ProtocolHandlers handlers;

    public ClasspathSource(String path, ProtocolHandlers handlers) {
        this.path = path;
        this.handlers = handlers;
        this.resources = new ArrayList<>();
    }

    @Override
    public Stream<Resource> resources() throws IOException {

        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (classpathResources.hasMoreElements()) {
            System.out.println("===============================");
            URL url = classpathResources.nextElement();
            URI uri;
            try {
                uri = url.toURI();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            System.out.println(uri);

            // Handle different protocols
            if ("jar".equals(url.getProtocol())) {
                int sep = url.toString().indexOf("!/");
                String insidePath = url.toString().substring(sep + 1);
                try (FileSystem fs = FileSystems.newFileSystem(uri, Map.of())) {
                    Path root = fs.getPath(insidePath);
                    try (Stream<Path> stream = Files.walk(root)) {
                        stream.forEach(System.out::println);
                    }
                }
            } else if ("file".equals(url.getProtocol())) {
                Path root = Path.of(uri);
                try (Stream<Path> stream = Files.walk(root)) {
                    stream.forEach(System.out::println);
                }
            }

            handlers.handle(url)
                    .ifPresent(resources::add);
        }
        return resources.stream();
    }
}
