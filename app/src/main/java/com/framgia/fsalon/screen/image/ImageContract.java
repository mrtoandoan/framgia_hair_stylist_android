package com.framgia.fsalon.screen.image;

import android.view.View;

import com.framgia.fsalon.BasePresenter;
import com.framgia.fsalon.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface ImageContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onImageClicked(View view);
        void onNavigateSuccess();
        void onNavigateFail();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void navigateToWebsite(String webUrl);
    }
}
