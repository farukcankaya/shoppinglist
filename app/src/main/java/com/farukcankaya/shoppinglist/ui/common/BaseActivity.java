package com.farukcankaya.shoppinglist.ui.common;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.farukcankaya.shoppinglist.R;
import com.farukcankaya.shoppinglist.ShoppingListApp;
import com.farukcankaya.shoppinglist.di.common.AppComponent;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @LayoutRes
    protected abstract int getContentViewLayoutResId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutResId());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected Toolbar getToolbar() {
        return toolbar;
    }

    protected AppComponent getAppComponent() {
        return ((ShoppingListApp) getApplication()).getAppComponent();
    }
}
