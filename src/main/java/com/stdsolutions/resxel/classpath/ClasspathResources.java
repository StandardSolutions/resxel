package com.stdsolutions.resxel.classpath;

import com.stdsolutions.resxel.Resource;
import com.stdsolutions.resxel.Resources;
import com.stdsolutions.resxel.local.LocalFsResource;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Stream;

public class ClasspathResources implements Resources {

    private final String path;

    private final List<Resource> resources;

    public ClasspathResources(String path) {
        this.path = path;
        this.resources = new ArrayList<>();
    }

    @Override
    public Stream<Resource> resources() throws IOException {

        Enumeration<URL> classpathResources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (classpathResources.hasMoreElements()) {
            URL url = classpathResources.nextElement();
            LocalFsResource localFsResource = new LocalFsResource(url);
            resources.add(localFsResource);
        }
        return resources.stream();
    }
}
