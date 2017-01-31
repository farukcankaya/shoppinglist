package com.farukcankaya.shoppinglist.di.common;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */
@Module
public class ActivityModule {

    @Provides
    @ActivityScope
    @Named("io")
    public Scheduler provideRxJavaIOScheduler() {
        return Schedulers.io();
    }

    @Provides
    @ActivityScope
    @Named("ui")
    public Scheduler getUIScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
