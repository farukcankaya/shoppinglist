package com.farukcankaya.shoppinglist.ui.shopping.list;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.farukcankaya.shoppinglist.R;
import com.farukcankaya.shoppinglist.di.basket.BasketModule;
import com.farukcankaya.shoppinglist.domain.model.Product;
import com.farukcankaya.shoppinglist.ui.common.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class BasketActivity extends BaseActivity
        implements BasketContract.ViewActions, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    BasketContract.UserActions presenter;

    @Override
    protected int getContentViewLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().plus(new BasketModule(this, 1))
                .inject(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, getToolbar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    protected void onPause() {
        presenter.pause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        presenter.stop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    @Override
    public void showProductList(List<Product> productList) {
        ((TextView) findViewById(R.id.hello)).setText(productList.size() + " " + productList.get(0).name());
    }

    @Override
    public void showProgress() {
        Snackbar.make(getToolbar(), "show progress", 3000).show();
    }

    @Override
    public void hideProgress() {
        ((TextView) findViewById(R.id.hello)).setText("bok");
        Snackbar.make(getToolbar(), "hide", 3000).show();
    }

    @Override
    public void showError(Throwable throwable) {
        ((TextView) findViewById(R.id.hello)).setText("oldu");
        Snackbar.make(getToolbar(), "error", 3000).show();
    }

    @Override
    public void hideError() {
        Snackbar.make(getToolbar(), "hide error", 3000).show();
    }
}
