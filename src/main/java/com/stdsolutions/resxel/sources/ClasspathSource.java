package com.stdsolutions.resxel.sources;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Source;
import com.stdsolutions.resxel.resources.FileResource;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Stream;

public class ClasspathSource implements Source {

    private final String path;

    private final List<Resource> resources;

    public ClasspathSource(String path) {
        this.path = path;
        this.resources = new ArrayList<>();
    }

    @Override
    public Stream<Resource> resources() throws IOException {

        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (classpathResources.hasMoreElements()) {
            URL url = classpathResources.nextElement();
            FileResource fileResource = new FileResource(url);
            resources.add(fileResource);
        }
        return resources.stream();
    }
}
