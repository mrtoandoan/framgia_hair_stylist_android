package com.framgia.fsalon.screen.booking;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.ArrayAdapter;

import com.framgia.fsalon.BR;
import com.framgia.fsalon.data.model.BookingRender;
import com.framgia.fsalon.data.model.DateBooking;
import com.framgia.fsalon.data.model.Salon;
import com.framgia.fsalon.data.model.Stylist;

import java.util.List;

/**
 * Exposes the data to be used in the Booking screen.
 */
public class BookingViewModel extends BaseObservable implements BookingContract.ViewModel {
    private BookingContract.Presenter mPresenter;
    private SalonAdapter mSalonAdapter;
    private DateBookingAdapter mDateAdapter;
    private TimeBookingAdapter mTimeAdapter;
    private List<Stylist> mStylists;
    private ArrayAdapter<Stylist> mStylistAdapter;

    public BookingViewModel(Context context) {
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
    public void setPresenter(BookingContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void selectedSalonPosition(int position, Salon salon) {
        if (salon == null) {
            return;
        }
        mSalonAdapter.selectedPosition(position);
    }

    @Override
    public void selectedDatePosition(int position, DateBooking dateBooking) {
        if (dateBooking == null) {
            return;
        }
        mDateAdapter.selectedPosition(position);
    }

    @Override
    public void selectedTimePosition(int position, BookingRender BookingRender) {
        if (BookingRender == null) {
            return;
        }
        mTimeAdapter.selectedPosition(position);
    }

    @Bindable
    public SalonAdapter getSalonAdapter() {
        return mSalonAdapter;
    }

    public void setSalonAdapter(SalonAdapter salonAdapter) {
        mSalonAdapter = salonAdapter;
        notifyPropertyChanged(BR.salonAdapter);
    }

    @Bindable
    public DateBookingAdapter getDateAdapter() {
        return mDateAdapter;
    }

    public void setDateAdapter(DateBookingAdapter dateAdapter) {
        mDateAdapter = dateAdapter;
        notifyPropertyChanged(BR.dateAdapter);
    }

    @Bindable
    public TimeBookingAdapter getTimeAdapter() {
        return mTimeAdapter;
    }

    public void setTimeAdapter(TimeBookingAdapter timeAdapter) {
        mTimeAdapter = timeAdapter;
        notifyPropertyChanged(BR.timeAdapter);
    }

    @Bindable
    public ArrayAdapter<Stylist> getStylistAdapter() {
        return mStylistAdapter;
    }

    public void setStylistAdapter(ArrayAdapter<Stylist> stylistAdapter) {
        mStylistAdapter = stylistAdapter;
        notifyPropertyChanged(BR.stylistAdapter);
    }
}
