package com.farukcankaya.shoppinglist.domain.model;

import com.google.auto.value.AutoValue;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

@AutoValue
public abstract class Amount {
    public abstract Double quantity();

    public abstract Unit unit();

    public static Amount create(final Double quantity, final Unit unit) {
        return new AutoValue_Amount(quantity, unit);
    }
}
