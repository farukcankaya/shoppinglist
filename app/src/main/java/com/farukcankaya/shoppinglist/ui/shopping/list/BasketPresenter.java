package com.farukcankaya.shoppinglist.ui.shopping.list;

import com.farukcankaya.shoppinglist.domain.model.Product;
import com.farukcankaya.shoppinglist.domain.usecase.BasketUsecase;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Named;

import rx.Scheduler;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

public class BasketPresenter implements BasketContract.UserActions {

    private final WeakReference<BasketContract.ViewActions> mViewActions;
    private Integer mBasketId;
    private final Scheduler mUiScheduler;
    private final Scheduler mIoScheduler;
    private final CompositeSubscription mSubscriptions;
    private final BasketUsecase mBasketUsecase;
    private boolean mIsDataLoaded = false;

    public BasketPresenter(final BasketContract.ViewActions viewActions,
                           final Integer basketId,
                           @Named("io") final Scheduler ioScheduler,
                           @Named("ui") final Scheduler uiScheduler,
                           final BasketUsecase basketUsecaseBuilder) {
        this.mViewActions = new WeakReference<>(viewActions);
        this.mBasketId = basketId;
        this.mIoScheduler = ioScheduler;
        this.mUiScheduler = uiScheduler;
        this.mSubscriptions = new CompositeSubscription();
        this.mBasketUsecase = basketUsecaseBuilder;
    }

    @Override
    public void resume() {
        if (!mIsDataLoaded) {
            mViewActions.get().showProgress();
            loadProducts();
        }
    }

    @Override
    public void pause() {
        mSubscriptions.clear(); // Unsubscribe from any ongoing subscription
    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    private void loadProducts() {
        final Subscription subscription =
                mBasketUsecase
                        .getProducts(mBasketId, null, null)
                        .subscribeOn(mIoScheduler)
                        .observeOn(mUiScheduler)
                        .subscribe(this::showProducts, e -> mViewActions.get().showError(e));
        mSubscriptions.add(subscription);
    }

    private void showProducts(final List<Product> products) {
        //mIsDataLoaded = true;
        mViewActions.get().hideProgress();
        mViewActions.get().showProductList(products);
    }
}
