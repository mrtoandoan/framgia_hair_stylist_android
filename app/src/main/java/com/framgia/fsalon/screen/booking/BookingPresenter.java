package com.framgia.fsalon.screen.booking;

import com.framgia.fsalon.R;
import com.framgia.fsalon.data.model.BookingResponse;
import com.framgia.fsalon.data.model.DateBooking;
import com.framgia.fsalon.data.model.Salon;
import com.framgia.fsalon.data.model.Stylist;
import com.framgia.fsalon.data.source.BookingRepository;
import com.framgia.fsalon.data.source.SalonRepository;
import com.framgia.fsalon.data.source.StylistRepository;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static com.framgia.fsalon.utils.Constant.A_DAY;

/**
 * Listens to user actions from the UI ({@link BookingActivity}), retrieves the data and updates
 * the UI as required.
 */
public class BookingPresenter implements BookingContract.Presenter {
    private static final String TAG = BookingPresenter.class.getName();
    private final BookingContract.ViewModel mViewModel;
    private CompositeSubscription mCompositeSubscriptions = new CompositeSubscription();
    private BookingRepository mBookingRepository;
    private SalonRepository mSalonRepository;
    private StylistRepository mStylistRepository;

    public BookingPresenter(BookingContract.ViewModel viewModel,
                            BookingRepository bookingRepository, SalonRepository salonRepository,
                            StylistRepository stylistRepository) {
        mViewModel = viewModel;
        mBookingRepository = bookingRepository;
        mSalonRepository = salonRepository;
        mStylistRepository = stylistRepository;
        getAllSalons();
        getDateBooking();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        mCompositeSubscriptions.clear();
    }

    @Override
    public void getAllSalons() {
        Subscription subscription = mSalonRepository.getAllSalons()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    mViewModel.showProgressbar();
                }
            })
            .subscribe(new Action1<List<Salon>>() {
                @Override
                public void call(List<Salon> salons) {
                    mViewModel.onGetSalonsSuccess(salons);
                }
            }, new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    mViewModel.hideProgressbar();
                    mViewModel.onError(throwable.getMessage());
                }
            }, new Action0() {
                @Override
                public void call() {
                    mViewModel.hideProgressbar();
                }
            });
        mCompositeSubscriptions.add(subscription);
    }

    @Override
    public void getAllStylists(int id) {
        Subscription subscription = mStylistRepository.getAllStylists(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    mViewModel.showProgressbar();
                }
            })
            .subscribe(new Action1<List<Stylist>>() {
                @Override
                public void call(List<Stylist> stylists) {
                    mViewModel.onGetStylistSuccess(stylists);
                }
            }, new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    mViewModel.hideProgressbar();
                    mViewModel.onError(throwable.getMessage());
                }
            }, new Action0() {
                @Override
                public void call() {
                    mViewModel.hideProgressbar();
                }
            });
        mCompositeSubscriptions.add(subscription);
    }

    @Override
    public void getBookings(int salonId, long time, int stylelistId) {
        Subscription subscription = mBookingRepository.getBookings(salonId, time, stylelistId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    mViewModel.showProgressbar();
                }
            })
            .subscribe(new Action1<BookingResponse>() {
                @Override
                public void call(BookingResponse bookingResponse) {
                    mViewModel.onGetBookingSuccess(bookingResponse);
                }
            }, new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    mViewModel.hideProgressbar();
                    mViewModel.onError(throwable.getMessage());
                }
            }, new Action0() {
                @Override
                public void call() {
                    mViewModel.hideProgressbar();
                }
            });
        mCompositeSubscriptions.add(subscription);
    }

    @Override
    public void getBookings(int salonId, long time) {
        Subscription subscription = mBookingRepository.getBookings(salonId, time)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    mViewModel.showProgressbar();
                }
            })
            .subscribe(new Action1<BookingResponse>() {
                @Override
                public void call(BookingResponse bookingResponse) {
                    mViewModel.onGetBookingSuccess(bookingResponse);
                }
            }, new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    mViewModel.hideProgressbar();
                    mViewModel.onError(throwable.getMessage());
                }
            }, new Action0() {
                @Override
                public void call() {
                    mViewModel.hideProgressbar();
                }
            });
        mCompositeSubscriptions.add(subscription);
    }

    @Override
    public void getDateBooking() {
        List<DateBooking> dateBookings = new ArrayList<>();
        dateBookings.add(new DateBooking(mViewModel.getStringRes(R.string.title_today),
            System.currentTimeMillis()));
        dateBookings.add(
            new DateBooking(mViewModel.getStringRes(R.string.title_tomorrow),
                System.currentTimeMillis()
                    + A_DAY));
        dateBookings
            .add(new DateBooking(mViewModel.getStringRes(R.string.title_after_tomorrow),
                System.currentTimeMillis() + A_DAY * 2));
        mViewModel.onGetDateBookingSuccess(dateBookings);
    }
}
