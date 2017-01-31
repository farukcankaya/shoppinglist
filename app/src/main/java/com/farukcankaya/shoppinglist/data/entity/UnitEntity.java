package com.farukcankaya.shoppinglist.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public class UnitEntity {
    @SerializedName("name")
    String name;
    @SerializedName("abbreviation")
    String abbreviation;

    public UnitEntity(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
