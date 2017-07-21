package com.framgia.fsalon.screen.image;

/**
 * Listens to user actions from the UI ({@link ImageFragment}), retrieves the data and updates
 * the UI as required.
 */
final class ImagePresenter implements ImageContract.Presenter {
    private final ImageContract.ViewModel mViewModel;

    public ImagePresenter(ImageContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void navigateToWebsite(String webUrl) {
        // TODO: 7/21/2017 navigateToWebSite
    }
}
