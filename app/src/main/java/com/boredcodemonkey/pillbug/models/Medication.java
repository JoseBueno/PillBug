package com.boredcodemonkey.pillbug.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public class Medication extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;

}
