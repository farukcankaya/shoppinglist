package com.farukcankaya.shoppinglist.data.local;

/**
 * Created by Faruk Cankaya on 1/30/17.
 */

public interface ObjectCache {
    String getAccessToken();

    boolean setAccessToken(String accessToken);
}
