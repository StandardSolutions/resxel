package com.stdsolutions.resxel.shared;

import java.net.URI;
import java.net.URL;

public final class PartedLocation {

    private final boolean isDefaultFilesystem;

    private final String fsPath;

    private final String dir;

    public PartedLocation(final String fsPath, final String dir) {
        this.isDefaultFilesystem = false;
        this.fsPath = fsPath;
        this.dir = dir;
    }

    public PartedLocation(final URI uri) {
        this.isDefaultFilesystem = "file".equals(uri.getScheme());
        this.fsPath = null;
        this.dir = null;
    }

    public PartedLocation(final URL url) {
        this.isDefaultFilesystem = "file".equals(url.getProtocol());
        this.fsPath = null;
        this.dir = null;
    }

}