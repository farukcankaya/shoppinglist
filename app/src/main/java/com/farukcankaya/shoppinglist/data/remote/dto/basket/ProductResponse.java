package com.farukcankaya.shoppinglist.data.remote.dto.basket;

import com.farukcankaya.shoppinglist.data.entity.ProductEntity;
import com.farukcankaya.shoppinglist.data.remote.dto.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public class ProductResponse extends BaseResponse {
    @SerializedName("product")
    ProductEntity productEntity;

    public ProductResponse() {
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }
}
