package com.stdsolutions.resxel;

import java.nio.file.Path;

public interface MigrationPath {

    Path value();

    boolean isClasspath();

    boolean isFileSystem();
}