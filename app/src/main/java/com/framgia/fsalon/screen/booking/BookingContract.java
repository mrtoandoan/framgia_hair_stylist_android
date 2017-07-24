package com.framgia.fsalon.screen.booking;

import com.framgia.fsalon.BasePresenter;
import com.framgia.fsalon.BaseViewModel;
import com.framgia.fsalon.data.model.BookingRender;
import com.framgia.fsalon.data.model.DateBooking;
import com.framgia.fsalon.data.model.Salon;

/**
 * This specifies the contract between the view and the presenter.
 */
interface BookingContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void selectedSalonPosition(int position, Salon salon);

        void selectedDatePosition(int position, DateBooking dateBooking);

        void selectedTimePosition(int position, BookingRender bookingRender);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
