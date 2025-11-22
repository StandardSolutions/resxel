package com.stdsolutions.resxel;

import java.nio.file.Path;

public interface Location {

    String scheme();

    Path source();

    String path();
}
