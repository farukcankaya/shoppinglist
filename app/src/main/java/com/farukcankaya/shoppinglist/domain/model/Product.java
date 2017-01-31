package com.farukcankaya.shoppinglist.domain.model;

import com.google.auto.value.AutoValue;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

@AutoValue
public abstract class Product {
    public abstract String name();

    public abstract int color();

    public abstract Amount amount();

    public static Product create(final String name, final int color, final Amount amount) {
        return new AutoValue_Product(name, color, amount);
    }
}
