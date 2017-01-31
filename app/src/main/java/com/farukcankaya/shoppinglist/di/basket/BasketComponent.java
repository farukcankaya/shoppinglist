package com.farukcankaya.shoppinglist.di.basket;

import com.farukcankaya.shoppinglist.di.common.ActivityScope;
import com.farukcankaya.shoppinglist.ui.shopping.list.BasketActivity;

import dagger.Subcomponent;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

@ActivityScope
@Subcomponent(
        modules = BasketModule.class
)
public interface BasketComponent {
    BasketActivity inject(BasketActivity activity);
}
