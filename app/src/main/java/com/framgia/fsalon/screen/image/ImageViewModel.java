package com.framgia.fsalon.screen.image;

import android.view.View;

/**
 * Exposes the data to be used in the Image screen.
 */
public class ImageViewModel implements ImageContract.ViewModel {
    private ImageContract.Presenter mPresenter;
    private int mUrl;

    public ImageViewModel(int url) {
        mUrl = url;
    }

    public int getUrl() {
        return mUrl;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(ImageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onImageClicked(View view) {
        // TODO: 7/21/2017 navigate to the suggested web
    }

    @Override
    public void onNavigateSuccess() {
        // TODO: 7/21/2017
    }

    @Override
    public void onNavigateFail() {
        // TODO: 7/21/2017
    }
}
