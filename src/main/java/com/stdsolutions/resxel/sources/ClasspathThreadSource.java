package com.stdsolutions.resxel.sources;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Stream;

public class ClasspathThreadSource {

    private final String path;


    public ClasspathThreadSource(String path) {
        this.path = path;
    }

    public Stream<URL> resources() throws IOException {
        List<URL> urls = new ArrayList<>();
        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (classpathResources.hasMoreElements()) {
            urls.add(classpathResources.nextElement());
        }
        return urls.stream();
    }
}