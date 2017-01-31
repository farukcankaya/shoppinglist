package com.farukcankaya.shoppinglist.di.common;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.farukcankaya.shoppinglist.data.local.ObjectCache;
import com.farukcankaya.shoppinglist.data.local.ObjectCacheImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(final Application application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    ObjectCache providesObjectCache(SharedPreferences sharedPreferences, Gson gson) {
        return new ObjectCacheImpl(sharedPreferences, gson);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        // you can add typeAdapter to builder here
        return builder.create();
    }
}
