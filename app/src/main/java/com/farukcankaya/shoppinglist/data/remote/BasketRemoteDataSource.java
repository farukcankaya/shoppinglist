package com.farukcankaya.shoppinglist.data.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.farukcankaya.shoppinglist.data.entity.BasketEntity;
import com.farukcankaya.shoppinglist.data.entity.ProductEntity;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Faruk Cankaya on 1/29/17.
 */

public class BasketRemoteDataSource {

    private ShoppingListService shoppingListService;

    @Inject
    public BasketRemoteDataSource(Retrofit retrofit) {
        this.shoppingListService = retrofit.create(ShoppingListService.class);
    }

    public Observable<List<BasketEntity>> requestBaskets(@Nullable Integer offset, @Nullable Integer limit) {
        return shoppingListService.basketListObservable(offset, limit).map(basketListResponse -> basketListResponse.getBasketEntityList());
    }

    public Observable<BasketEntity> requestBasket(@NonNull Integer basketId) {
        return shoppingListService.basketObservable(basketId).map(basketResponse -> basketResponse.getBasketEntity());
    }

    public Observable<List<ProductEntity>> requestProducts(@Nullable Integer basketId,
                                                           @Nullable Integer offset,
                                                           @Nullable Integer limit) {
        return shoppingListService.productListObservable(basketId, offset, limit).map(
                productListResponse -> productListResponse.getProductEntityList());
    }

    public Observable<ProductEntity> requestProduct(@NonNull Integer productId) {
        return shoppingListService.productObservable(productId).map(productResponse -> productResponse.getProductEntity());
    }
}
