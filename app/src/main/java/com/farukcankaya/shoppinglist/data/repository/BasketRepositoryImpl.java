package com.farukcankaya.shoppinglist.data.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.farukcankaya.shoppinglist.data.entity.BasketEntity;
import com.farukcankaya.shoppinglist.data.entity.ProductEntity;
import com.farukcankaya.shoppinglist.data.local.BasketLocalDataSource;
import com.farukcankaya.shoppinglist.data.remote.BasketRemoteDataSource;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public class BasketRepositoryImpl implements BasketRepository {
    private BasketRemoteDataSource basketRemoteDataSource;
    private BasketLocalDataSource basketLocalDataSource;

    @Inject
    public BasketRepositoryImpl(BasketRemoteDataSource basketRemoteDataSource,
                                BasketLocalDataSource basketLocalDataSource) {
        this.basketRemoteDataSource = basketRemoteDataSource;
        this.basketLocalDataSource = basketLocalDataSource;
    }

    @Override
    public Observable<List<BasketEntity>> requestBaskets(@Nullable Integer offset,
                                                         @Nullable Integer limit) {
        return null;
    }

    @Override
    public Observable<BasketEntity> requestBasket(@NonNull Integer basketId) {
        return null;
    }

    @Override
    public Observable<List<ProductEntity>> requestProducts(@Nullable Integer basketId,
                                                           @Nullable Integer offset,
                                                           @Nullable Integer limit) {
        Observable<List<ProductEntity>>
                basketRemoteDataSourceObservable = basketRemoteDataSource.requestProducts(basketId,
                offset, limit);
        Observable<List<ProductEntity>>
                basketLocalDataSourceObservable = basketLocalDataSource.requestProducts(basketId,
                offset, limit);

        return basketRemoteDataSourceObservable.publish(remoteProductListResponse ->
                Observable.merge(remoteProductListResponse, // Merge network and local
                        basketLocalDataSourceObservable // but stop local as soon as network emits
                ))
                .onErrorResumeNext(throwable -> basketLocalDataSourceObservable)
                .distinct();
    }

    @Override
    public Observable<ProductEntity> requestProduct(@NonNull Integer productId) {
        return null;
    }
}
