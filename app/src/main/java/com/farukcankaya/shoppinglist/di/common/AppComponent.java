package com.farukcankaya.shoppinglist.di.common;

import com.farukcankaya.shoppinglist.di.basket.BasketComponent;
import com.farukcankaya.shoppinglist.di.basket.BasketModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class})
public interface AppComponent {
    BasketComponent plus(BasketModule basketModule);
}
