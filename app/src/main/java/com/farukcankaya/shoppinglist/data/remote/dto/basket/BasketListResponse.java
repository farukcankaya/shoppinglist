package com.farukcankaya.shoppinglist.data.remote.dto.basket;

import com.farukcankaya.shoppinglist.data.entity.BasketEntity;
import com.farukcankaya.shoppinglist.data.remote.dto.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public class BasketListResponse extends BaseResponse {
    @SerializedName("baskets")
    List<BasketEntity> basketEntityList;

    public BasketListResponse() {
    }

    public List<BasketEntity> getBasketEntityList() {
        return basketEntityList;
    }
}
