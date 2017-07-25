package com.framgia.fsalon.screen.homeadmin;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;

import com.framgia.fsalon.BR;

import static com.framgia.fsalon.screen.homeadmin.AdminHomeViewModel.Tab.TAB_CUSTOMER;
import static com.framgia.fsalon.screen.homeadmin.AdminHomeViewModel.Tab.TAB_PROFILE;
import static com.framgia.fsalon.screen.homeadmin.AdminHomeViewModel.Tab.TAB_RECEIPT;
import static com.framgia.fsalon.screen.homeadmin.AdminHomeViewModel.Tab.TAB_REPORT;
import static com.framgia.fsalon.screen.homeadmin.AdminHomeViewModel.Tab.TAB_SCHEDULER;

/**
 * Exposes the data to be used in the Adminhome screen.
 */
public class AdminHomeViewModel extends BaseObservable implements AdminHomeContract.ViewModel {
    private AdminHomeContract.Presenter mPresenter;
    private AppCompatActivity mActivity;

    public AdminHomeViewModel(AppCompatActivity activity) {
        mActivity = activity;
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
    public void setPresenter(AdminHomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @IntDef({TAB_SCHEDULER, TAB_CUSTOMER, TAB_RECEIPT, TAB_REPORT, TAB_PROFILE})
    public @interface Tab {
        int TAB_SCHEDULER = 0;
        int TAB_CUSTOMER = 1;
        int TAB_RECEIPT = 2;
        int TAB_REPORT = 3;
        int TAB_PROFILE = 4;
    }

    @Bindable
    public AppCompatActivity getActivity() {
        return mActivity;
    }

    public void setActivity(AppCompatActivity activity) {
        mActivity = activity;
        notifyPropertyChanged(BR.activity);
    }
}
