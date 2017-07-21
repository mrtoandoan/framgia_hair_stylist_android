package com.framgia.fsalon.screen.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.framgia.fsalon.screen.image.ImageFragment;

import java.util.List;

/**
 * Created by THM on 7/20/2017.
 */
public class ImagePagerAdapter extends FragmentPagerAdapter {
    private List<ImageFragment> mFragments;

    public ImagePagerAdapter(FragmentManager fm, List<ImageFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    public void setFragments(List<ImageFragment> fragments) {
        mFragments = fragments;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }
}
