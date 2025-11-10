package com.stdsolutions.resxel.uri;

import java.net.URI;
import java.net.URL;

public final class DecodedLocation {

    private final boolean isDefaultFilesystem;

    private final String fsPath;

    private final String dir;

    public DecodedLocation(String fsPath, String dir) {
        this.isDefaultFilesystem = false;
        this.fsPath = fsPath;
        this.dir = dir;
    }

    public DecodedLocation(URI uri) {
        this.isDefaultFilesystem = "file".equals(uri.getScheme());
        this.fsPath = null;
        this.dir = null;
    }

    public DecodedLocation(URL url) {
        this.isDefaultFilesystem = "file".equals(url.getProtocol());
        this.fsPath = null;
        this.dir = null;
    }

}
