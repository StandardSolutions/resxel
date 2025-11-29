package com.stdsolutions.resxel.location;

import com.stdsolutions.resxel.Location3;

import java.net.URI;

final class UnexpectedLocation3 implements Location3 {

    private final String location;

    public UnexpectedLocation3(final String location) {
        this.location = location;
    }

    @Override
    public String scheme() {
        return "unexpected";
    }

    @Override
    public URI source() {
        return URI.create("");
    }

    @Override
    public String path() {
        return "";
    }
}
