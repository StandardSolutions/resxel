package com.stdsolutions.resxel;

public interface ResPath {

    @Override
    String toString();

    class Default implements ResPath {

        private final String stringPath;

        public Default(final String stringPath) {
            this.stringPath = stringPath;
        }

        @Override
        public String toString() {
            return stringPath;
        }
    }
}
