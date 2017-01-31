package com.farukcankaya.shoppinglist.di.basket;

import com.farukcankaya.shoppinglist.data.local.BasketLocalDataSource;
import com.farukcankaya.shoppinglist.data.remote.BasketRemoteDataSource;
import com.farukcankaya.shoppinglist.data.repository.BasketRepository;
import com.farukcankaya.shoppinglist.data.repository.BasketRepositoryImpl;
import com.farukcankaya.shoppinglist.di.common.ActivityScope;
import com.farukcankaya.shoppinglist.di.common.ActivityModule;
import com.farukcankaya.shoppinglist.domain.usecase.BasketUsecase;
import com.farukcankaya.shoppinglist.ui.shopping.list.BasketActivity;
import com.farukcankaya.shoppinglist.ui.shopping.list.BasketContract;
import com.farukcankaya.shoppinglist.ui.shopping.list.BasketPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import rx.Scheduler;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

@Module
public class BasketModule extends ActivityModule {
    private BasketActivity basketActivity;
    private final Integer mBasketId;

    public BasketModule(final BasketActivity basketActivity, final Integer basketId) {
        this.basketActivity = basketActivity;
        this.mBasketId = basketId;
    }

    @Provides
    @ActivityScope
    public BasketActivity provideBasketActivity() {
        return basketActivity;
    }

    @Provides
    @ActivityScope
    public BasketRepository provideBasketRepository(Retrofit retrofit) {
        return new BasketRepositoryImpl(new BasketRemoteDataSource(retrofit),
                new BasketLocalDataSource());
    }

    @Provides
    @ActivityScope
    public BasketUsecase provideBasketUsecase(BasketRepository basketRepository) {
        return new BasketUsecase(basketRepository);
    }

    @Provides
    @ActivityScope
    public BasketPresenter provideBasketPresenter(@Named("io") final Scheduler ioScheduler,
                                                  @Named("ui") final Scheduler uiScheduler,
                                                  final BasketUsecase basketUsecase) {
        return new BasketPresenter(basketActivity, mBasketId, ioScheduler, uiScheduler, basketUsecase);
    }

    @Provides
    @ActivityScope
    public BasketContract.UserActions provideBasketActivityUserActions(BasketPresenter basketPresenter) {
        return basketPresenter;
    }
}
