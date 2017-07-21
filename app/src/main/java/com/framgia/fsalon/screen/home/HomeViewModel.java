package com.framgia.fsalon.screen.home;

import com.framgia.fsalon.R;
import com.framgia.fsalon.screen.image.ImageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Home screen.
 */
public class HomeViewModel implements HomeContract.ViewModel {
    private HomeContract.Presenter mPresenter;
    private List<ImageFragment> mFragments = new ArrayList<>();
    private ImagePagerAdapter mAdapter;

    public HomeViewModel(ImagePagerAdapter imagePagerAdapter) {
        mFragments.add(ImageFragment.newInstance(R.drawable.bg_gradient));
        mFragments.add(ImageFragment.newInstance(R.drawable.ic_scissors_comb_40dp));
        mFragments.add(ImageFragment.newInstance(R.drawable.bg_gradient));
        mFragments.add(ImageFragment.newInstance(R.drawable.ic_scissors_comb_40dp));
        mAdapter = imagePagerAdapter;
        mAdapter.setFragments(mFragments);
    }

    public ImagePagerAdapter getAdapter() {
        return mAdapter;
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
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onGetUrlSuccess(List<String> urls) {
        // TODO: 7/21/2017 change adapter by urls
    }

    @Override
    public void onGetUrlFail() {
    }

    @Override
    public void onBookingClick() {
    }

    @Override
    public void onDetailListClick() {
    }

    @Override
    public void onHistoryClick() {
    }
}
