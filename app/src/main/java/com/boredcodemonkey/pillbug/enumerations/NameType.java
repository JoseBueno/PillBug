package com.boredcodemonkey.pillbug.enumerations;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public enum NameType {
    Generic("Generic", "G"),
    Brand("Brand", "B");

    private final String longName;
    private final String shortName;

    private NameType(String longName, String shortName) {
        this.longName = longName;
        this.shortName = shortName;
    }

    public static NameType fromShortName(String shortName) {
        if (shortName.equals("G")) {
            return NameType.Generic;
        } else {
            return NameType.Brand;
        }
    }

    public static NameType fromLongName(String longName) {
        if (longName.equals("Generic")) {
            return NameType.Generic;
        } else {
            return NameType.Brand;
        }
    }

    @Override
    public String toString() {
        return longName;
    }
}
