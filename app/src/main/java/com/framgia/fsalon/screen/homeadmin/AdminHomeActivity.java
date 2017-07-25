package com.framgia.fsalon.screen.homeadmin;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.framgia.fsalon.R;
import com.framgia.fsalon.databinding.ActivityAdminHomeBinding;

/**
 * Adminhome Screen.
 */
public class AdminHomeActivity extends AppCompatActivity {
    private AdminHomeContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new AdminHomeViewModel(this);
        AdminHomeContract.Presenter presenter =
            new AdminHomePresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        ActivityAdminHomeBinding binding =
            DataBindingUtil.setContentView(this, R.layout.activity_admin_home);
        binding.setViewModel((AdminHomeViewModel) mViewModel);
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
}
