package com.farukcankaya.shoppinglist.ui.shopping.list;

import com.farukcankaya.shoppinglist.domain.model.Product;
import com.farukcankaya.shoppinglist.ui.common.BaseContract;

import java.util.List;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */
public interface BasketContract {

    interface ViewActions extends BaseContract.ViewActions {

        void showProductList(List<Product> productList);
    }

    interface UserActions extends BaseContract.UserActions {

    }
}