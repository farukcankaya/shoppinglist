package com.farukcankaya.shoppinglist.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public class AmountEntity {
    @SerializedName("quantity")
    Double quantity;
    @SerializedName("unit")
    UnitEntity unit;

    public AmountEntity(Double quantity, UnitEntity unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public void setUnit(UnitEntity unit) {
        this.unit = unit;
    }
}
