package com.farukcankaya.shoppinglist.data.remote;

import com.farukcankaya.shoppinglist.data.remote.dto.basket.BasketListResponse;
import com.farukcankaya.shoppinglist.data.remote.dto.basket.BasketResponse;
import com.farukcankaya.shoppinglist.data.remote.dto.basket.ProductListResponse;
import com.farukcankaya.shoppinglist.data.remote.dto.basket.ProductResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

public interface ShoppingListService {
    @GET("baskets")
    Observable<BasketListResponse> basketListObservable(@Query("offset") Integer offset,
                                                        @Query("limit") Integer limit);

    @GET("baskets/{basketId}")
    Observable<BasketResponse> basketObservable(@Path("basketId") Integer basketId);

    @GET("baskets/{basketId}/products")
    Observable<ProductListResponse> productListObservable(@Path("basketId") Integer basketId,
                                                          @Query("offset") Integer offset,
                                                          @Query("limit") Integer limit);

    @GET("products/{productId}")
    Observable<ProductResponse> productObservable(@Path("productId") Integer productId);
}
