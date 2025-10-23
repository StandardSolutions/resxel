package com.stdsolutions.resxel.localfs;

import com.stdsolutions.resxel.Origin;
import com.stdsolutions.resxel.Resource;

import java.io.IOException;

public class LocalFsResource implements Resource {
    @Override
    public byte[] asBytes() throws IOException {
        return new byte[0];
    }

    @Override
    public Origin origin() {
        return null;
    }
}
