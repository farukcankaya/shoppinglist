package com.farukcankaya.shoppinglist.data.local;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.farukcankaya.shoppinglist.data.entity.AmountEntity;
import com.farukcankaya.shoppinglist.data.entity.ProductEntity;
import com.farukcankaya.shoppinglist.data.entity.UnitEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public class BasketLocalDataSource {

    @Inject
    public BasketLocalDataSource() {
    }

    public Observable<List<ProductEntity>> requestProducts(@Nullable Integer basketId,
                                                           @Nullable Integer offset,
                                                           @Nullable Integer limit) {
        int productCount = 10;
        List<ProductEntity> products = new ArrayList<>(productCount);
        UnitEntity unit = new UnitEntity("TL", "TL");
        AmountEntity amount = new AmountEntity(Double.parseDouble("1"), unit);
        ProductEntity product = new ProductEntity("name", Color.RED, amount);
        Observable.range(0, productCount).subscribe(integer -> {
            product.getAmount().getQuantity();
            products.add(product);
        });
        return Observable.from(Arrays.asList(products));
    }
}
