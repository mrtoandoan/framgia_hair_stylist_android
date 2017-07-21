package com.framgia.fsalon.screen.image;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.fsalon.R;
import com.framgia.fsalon.databinding.FragmentImageBinding;

/**
 * Image Screen.
 */
public class ImageFragment extends Fragment {
    private static final String BUNDLE_URL = "BUNDLE_URL";
    private ImageContract.ViewModel mViewModel;

    public static ImageFragment newInstance(int url) {
        ImageFragment imageFragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(BUNDLE_URL, url);
        imageFragment.setArguments(args);
        return imageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ImageViewModel(getArguments().getInt(BUNDLE_URL));
        ImageContract.Presenter presenter = new ImagePresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentImageBinding binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_image, container, false);
        binding.setViewModel((ImageViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
