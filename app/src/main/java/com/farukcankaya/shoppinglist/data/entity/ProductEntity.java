package com.farukcankaya.shoppinglist.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public class ProductEntity {
    @SerializedName("name")
    String name;
    @SerializedName("color")
    int color;
    @SerializedName("amount")
    AmountEntity amount;

    public ProductEntity(String name, int color, AmountEntity amount) {
        this.name = name;
        this.color = color;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public AmountEntity getAmount() {
        return amount;
    }
}
