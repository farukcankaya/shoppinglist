package com.farukcankaya.shoppinglist.ui.common;

/**
 * Created by Faruk Cankaya on 1/28/17.
 */

public interface BaseContract {
    interface ViewActions {
        void showProgress();

        void hideProgress();

        void showError(Throwable throwable);

        void hideError();
    }

    interface UserActions {
        void resume();

        void pause();

        void stop();

        void destroy();
    }
}
