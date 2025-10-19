package com.stdsolutions.resxel;

import com.stdsolutions.resxel.list.FileListImpl;
import com.stdsolutions.resxel.path.PathOf;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

public final class FileListOf {
    private final MigrationPath path;

    public FileListOf(MigrationPath path) {
        this.path = path;
    }

    public FileList value() throws IOException, URISyntaxException {
        if (path.isFileSystem()) {
            PathOf pathOf = new PathOf(path.value().toUri());
            return new FileListImpl(pathOf);
        }

        if (path.isClasspath()) {
            String resourcePath = path.toString();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            Enumeration<URL> resources = classLoader.getResources(resourcePath);
            if (!resources.hasMoreElements()) {
                return List::of;
            }

            URL migrationsUrl = resources.nextElement();

            if (resources.hasMoreElements()) {
                throw new IllegalStateException("Multiple resources found for path: " + resourcePath);
            }

            return switch (migrationsUrl.getProtocol()) {
                case "file" -> new FileListImpl(new PathOf(path.value().toUri()));
                case "jar" -> new FileListImpl(new PathOf(migrationsUrl.toURI()));
                default -> throw new IllegalStateException("Unsupported protocol: " + migrationsUrl.getProtocol());
            };
        }
        throw new IllegalStateException("Path must contain a valid prefix (filesystem: or classpath:): " + path);
    }


}