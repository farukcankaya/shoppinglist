package com.farukcankaya.shoppinglist;

import android.app.Application;

import com.farukcankaya.shoppinglist.di.common.AppComponent;
import com.farukcankaya.shoppinglist.di.common.ApplicationModule;
import com.farukcankaya.shoppinglist.di.common.DaggerAppComponent;
import com.farukcankaya.shoppinglist.di.common.NetworkModule;

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

public class ShoppingListApp extends Application {
    // can be static
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeInjector();
    }

    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(BuildConfig.API_URL,
                        RxJavaCallAdapterFactory.create()))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
