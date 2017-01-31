package com.farukcankaya.shoppinglist.domain.usecase;

import android.support.annotation.Nullable;

import com.farukcankaya.shoppinglist.data.repository.BasketRepository;
import com.farukcankaya.shoppinglist.domain.mapper.BasketsDataMapper;
import com.farukcankaya.shoppinglist.domain.model.Product;

import java.util.List;

import rx.Observable;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

public class BasketUsecase {
    private BasketRepository basketRepository;

    public BasketUsecase(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public Observable<List<Product>> getProducts(@Nullable final Integer basketId,
                                                 @Nullable final Integer offset,
                                                 @Nullable final Integer limit) {

        return basketRepository.requestProducts(basketId, offset, limit)
                .distinct() // Avoid emitting twice the same list of items
                .map(BasketsDataMapper::convertProductsToDomain);
    }
}
