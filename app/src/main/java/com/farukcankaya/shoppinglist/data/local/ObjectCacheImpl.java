package com.farukcankaya.shoppinglist.data.local;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public class ObjectCacheImpl implements ObjectCache {

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public static String USER_ACCESS_TOKEN = "user.access.token";

    @Inject
    public ObjectCacheImpl(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    @Override
    public String getAccessToken() {
        return sharedPreferences.getString(USER_ACCESS_TOKEN, null);
    }

    @Override
    public boolean setAccessToken(String accessToken) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (accessToken == null) {
            editor.remove(USER_ACCESS_TOKEN);
        } else {
            editor.putString(USER_ACCESS_TOKEN, accessToken);
        }
        return editor.commit();
    }
}
