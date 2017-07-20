package com.framgia.fsalon.screen.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.framgia.fsalon.data.source.UserRepository;
import com.framgia.fsalon.data.source.api.FSalonServiceClient;
import com.framgia.fsalon.data.source.remote.UserRemoteDataSource;

import com.framgia.fsalon.R;
import com.framgia.fsalon.databinding.ActivityLoginBinding;

/**
 * Login Screen.
 */
public class LoginActivity extends AppCompatActivity {
    private LoginContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new LoginViewModel(this);
        LoginContract.Presenter presenter =
            new LoginPresenter(mViewModel,
                new UserRepository(new UserRemoteDataSource(FSalonServiceClient
                    .getInstance())));
        mViewModel.setPresenter(presenter);
        ActivityLoginBinding binding =
            DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewModel((LoginViewModel) mViewModel);
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
