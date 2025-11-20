package com.stdsolutions.resxel.filesystem;

class ParsedScheme {

    private final String location;

    ParsedScheme(final String location) {
        this.location = location;
    }

    String value() {
        final int idx = location.indexOf(":");
        if (idx < 2) {
            return "file";
        }
        return location.substring(0, idx);
    }

    int cutPoint() {
        final int idx = location.indexOf(":");
        if (idx == -1) {
            return 0;
        }
        return idx < 2 ? 0 : idx + 1;
    }
}