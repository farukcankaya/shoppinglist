package com.farukcankaya.shoppinglist.di.common;

import android.os.Build;

import com.farukcankaya.shoppinglist.BuildConfig;
import com.farukcankaya.shoppinglist.data.local.ObjectCache;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

@Module
public class NetworkModule {
    private final HttpUrl mBaseUrl;
    private final CallAdapter.Factory mRxAdapter;

    public NetworkModule(final String baseUrl, final CallAdapter.Factory rxAdapter) {
        mBaseUrl = HttpUrl.parse(baseUrl);
        mRxAdapter = rxAdapter;
    }

    public NetworkModule(final HttpUrl baseUrl, final CallAdapter.Factory rxAdapter) {
        mBaseUrl = baseUrl;
        mRxAdapter = rxAdapter;
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    @Named("AuthenticationInterceptor")
    Interceptor provideAuthenticationInterceptor(ObjectCache objectCache) {
        return (chain) -> {
            Request request = chain.request();
            Request newRequest;
            Request.Builder builder = request.newBuilder();

            String accessToken = objectCache.getAccessToken();
            if (accessToken != null) {
                builder.addHeader("Authorization", accessToken);
            }
            builder.addHeader("X-Platform", "ANDROID")
                    .addHeader("X-Client-Version", String.valueOf(BuildConfig.VERSION_NAME))
                    .addHeader("X-OS-Version", String.valueOf(Build.VERSION.RELEASE))
                    .addHeader("Accept-Language", Locale.getDefault().getLanguage().toUpperCase());
            newRequest = builder.build();

            // Response Intercept
            Response response = chain.proceed(newRequest);

            /**
             * You can check authorization error here like that:
             * boolean unAuthorized = (response.code() == 401);
             if (unAuthorized) {
             throw new AuthorizeException();
             }
             */
            return response;
        };
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                     @Named("AuthenticationInterceptor") Interceptor authenticationInterceptor) {
        List<Protocol> protocols = new ArrayList<>();
        protocols.add(Protocol.HTTP_1_1);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(1, TimeUnit.MINUTES);
        okHttpClient.readTimeout(1, TimeUnit.MINUTES);
        okHttpClient.protocols(protocols);
        okHttpClient.addInterceptor(httpLoggingInterceptor);
        okHttpClient.addInterceptor(authenticationInterceptor);
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(mRxAdapter)
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
