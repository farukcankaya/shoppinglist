package com.farukcankaya.shoppinglist.data.remote.dto.basket;

import com.farukcankaya.shoppinglist.data.entity.ProductEntity;
import com.farukcankaya.shoppinglist.data.remote.dto.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public class ProductListResponse extends BaseResponse {
    @SerializedName("products")
    List<ProductEntity> productEntityList;

    public ProductListResponse() {
    }

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }
}
