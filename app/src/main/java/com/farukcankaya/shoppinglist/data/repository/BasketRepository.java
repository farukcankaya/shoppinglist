package com.farukcankaya.shoppinglist.data.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.farukcankaya.shoppinglist.data.entity.BasketEntity;
import com.farukcankaya.shoppinglist.data.entity.ProductEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public interface BasketRepository {
    Observable<List<BasketEntity>> requestBaskets(@Nullable Integer offset,
                                                  @Nullable Integer limit);

    Observable<BasketEntity> requestBasket(@NonNull Integer basketId);

    Observable<List<ProductEntity>> requestProducts(@Nullable Integer basketId,
                                                    @Nullable Integer offset,
                                                    @Nullable Integer limit);

    Observable<ProductEntity> requestProduct(@NonNull Integer productId);
}
