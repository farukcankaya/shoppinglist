package com.farukcankaya.shoppinglist.domain.model;

import com.google.auto.value.AutoValue;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

@AutoValue
public abstract class Unit {
    public abstract String name();

    public abstract String abbreviation();

    public static Unit create(final String name, final String abbreviation) {
        return new AutoValue_Unit(name, abbreviation);
    }
}
