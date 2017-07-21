package com.framgia.fsalon.screen.home;

/**
 * Listens to user actions from the UI ({@link HomeActivity}), retrieves the data and updates
 * the UI as required.
 */
final class HomePresenter implements HomeContract.Presenter {
    private static final String TAG = HomePresenter.class.getName();
    private final HomeContract.ViewModel mViewModel;

    public HomePresenter(HomeContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
        // TODO: 7/20/2017 get image url for tab layout
        getUrls();
    }

    @Override
    public void onStop() {
    }

    @Override
    public void getUrls() {
    }
}
