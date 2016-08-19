package com.boredcodemonkey.pillbug.enumeration;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public enum DrugClass {
    Generic("Generic", "G"),
    Brand("Brand", "B");

    private final String longName;
    private final String shortName;

    private DrugClass(String longName, String shortName) {
        this.longName = longName;
        this.shortName = shortName;
    }

    public static DrugClass fromShortName(String shortName) {
        if (shortName.equals("G")) {
            return DrugClass.Generic;
        } else {
            return DrugClass.Brand;
        }
    }

    public static DrugClass fromLongName(String longName) {
        if (longName.equals("Generic")) {
            return DrugClass.Generic;
        } else {
            return DrugClass.Brand;
        }
    }

    @Override
    public String toString() {
        return "DrugClass{" +
                "longName='" + longName + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
