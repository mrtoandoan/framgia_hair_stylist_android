package com.framgia.fsalon.screen.booking;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.framgia.fsalon.R;
import com.framgia.fsalon.data.source.BookingRepository;
import com.framgia.fsalon.data.source.SalonRepository;
import com.framgia.fsalon.data.source.StylistRepository;
import com.framgia.fsalon.data.source.api.FSalonServiceClient;
import com.framgia.fsalon.data.source.remote.BookingRemoteDataSource;
import com.framgia.fsalon.data.source.remote.SalonRemoteDataSource;
import com.framgia.fsalon.data.source.remote.StylistRemoteDataSource;
import com.framgia.fsalon.databinding.ActivityBookingBinding;

/**
 * Booking Screen.
 */
public class BookingActivity extends AppCompatActivity {
    private BookingContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new BookingViewModel(this);
        BookingContract.Presenter presenter =
            new BookingPresenter(mViewModel, new BookingRepository(new BookingRemoteDataSource(
                FSalonServiceClient.getInstance())), new SalonRepository(new SalonRemoteDataSource
                (FSalonServiceClient.getInstance())), new StylistRepository(new
                StylistRemoteDataSource(FSalonServiceClient.getInstance())));
        mViewModel.setPresenter(presenter);
        ActivityBookingBinding binding =
            DataBindingUtil.setContentView(this, R.layout.activity_booking);
        binding.setViewModel((BookingViewModel) mViewModel);
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
