package com.framgia.fsalon.screen.home;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import com.framgia.fsalon.R;
import com.framgia.fsalon.data.model.BookingResponse;
import com.framgia.fsalon.data.source.BookingDataRepository;
import com.framgia.fsalon.data.source.api.FSalonServiceClient;
import com.framgia.fsalon.data.source.remote.BookingRemoteDataSource;
import com.framgia.fsalon.databinding.ActivityHomeBinding;
import com.framgia.fsalon.screen.image.ImageFragment;
import java.util.ArrayList;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Home Screen.
 */
public class HomeActivity extends AppCompatActivity {

    private HomeContract.ViewModel mViewModel;

    public static Intent getInstance(Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<ImageFragment> fragments = new ArrayList<>();
        ImagePagerAdapter imagePagerAdapter =
            new ImagePagerAdapter(getSupportFragmentManager(), fragments);
        mViewModel = new HomeViewModel(imagePagerAdapter);
        HomeContract.Presenter presenter = new HomePresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        final ActivityHomeBinding binding =
            DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setViewModel((HomeViewModel) mViewModel);
        setSupportActionBar(binding.toolbarHome);
        binding.pagerImages.setCycle(true);
        binding.pagerImages.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                int positionOffsetPixels) {
                binding.pagerImages.startAutoScroll(7000);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
}
