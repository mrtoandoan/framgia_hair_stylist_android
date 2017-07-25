package com.framgia.fsalon.screen.booking;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.framgia.fsalon.BR;
import com.framgia.fsalon.R;
import com.framgia.fsalon.data.model.BookingRender;
import com.framgia.fsalon.data.model.BookingResponse;
import com.framgia.fsalon.data.model.DateBooking;
import com.framgia.fsalon.data.model.Salon;
import com.framgia.fsalon.data.model.Stylist;

import java.util.List;

import static com.framgia.fsalon.utils.Constant.OUT_OF_INDEX;

/**
 * Exposes the data to be used in the Booking screen.
 */
public class BookingViewModel extends BaseObservable implements BookingContract.ViewModel {
    private BookingContract.Presenter mPresenter;
    private SalonAdapter mSalonAdapter;
    private DateBookingAdapter mDateAdapter;
    private TimeBookingAdapter mTimeAdapter;
    private ArrayAdapter<Stylist> mStylistAdapter;
    private AppCompatActivity mActivity;
    private Context mContext;
    private long mTime = System.currentTimeMillis() / 1000;
    private int mSalonId;
    private int mStylistId = OUT_OF_INDEX;

    public BookingViewModel(AppCompatActivity activity) {
        mActivity = activity;
        mContext = activity.getApplicationContext();
    }

    @Override
    public String getStringRes(int resId) {
        return mContext.getResources().getString(resId);
    }

    @Override
    public void onGetDateBookingSuccess(List<DateBooking> dateBookings) {
        setDateAdapter(new DateBookingAdapter(mContext, dateBookings, this));
    }

    @Override
    public void getData() {
        mPresenter.getBookings(mSalonId, mTime, mStylistId);
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
        mSalonId = salon.getId();
        mPresenter.getAllStylists(mSalonId);
        getData();
    }

    @Override
    public void selectedDatePosition(int position, DateBooking dateBooking) {
        if (dateBooking == null) {
            return;
        }
        mDateAdapter.selectedPosition(position);
        mTime = dateBooking.getTimeMillis();
        getData();
    }

    @Override
    public void selectedTimePosition(int position, BookingRender bookingRender) {
        if (bookingRender == null) {
            return;
        }
        mTimeAdapter.selectedPosition(position);
    }

    @Override
    public void onError(String msg) {
        Snackbar.make(mActivity.findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG)
            .show();
    }

    @Override
    public void showProgressbar() {
        // TODO: 24/07/2017
    }

    @Override
    public void hideProgressbar() {
        // TODO: 24/07/2017
    }

    @Override
    public void onGetSalonsSuccess(List<Salon> salons) {
        setSalonAdapter(new SalonAdapter(mContext, salons, this));
    }

    @Override
    public void onGetStylistSuccess(List<Stylist> stylists) {
        setStylistAdapter(new ArrayAdapter<>(mContext, R.layout.item_spinner, stylists));
    }

    @Override
    public void onGetBookingSuccess(BookingResponse bookingResponse) {
        setTimeAdapter(new TimeBookingAdapter(mContext, bookingResponse.getRenders(), this));
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

    @Bindable
    public int getStylistId() {
        return mStylistId;
    }

    public void setStylistId(int stylistId) {
        mStylistId = stylistId;
        notifyPropertyChanged(BR.stylistId);
    }
}
