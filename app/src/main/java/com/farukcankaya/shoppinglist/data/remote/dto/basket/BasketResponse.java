package com.farukcankaya.shoppinglist.data.remote.dto.basket;

import com.farukcankaya.shoppinglist.data.entity.BasketEntity;
import com.farukcankaya.shoppinglist.data.remote.dto.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public class BasketResponse extends BaseResponse {
    @SerializedName("basket")
    BasketEntity basketEntity;

    public BasketResponse() {
    }

    public BasketEntity getBasketEntity() {
        return basketEntity;
    }
}
