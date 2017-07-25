package com.framgia.fsalon.data.source;

import com.framgia.fsalon.data.model.BookingResponse;
import rx.Observable;

/**
 * Created by framgia on 7/21/17.
 */

public class BookingRepository implements BookingDataSource {

    private BookingDataSource mRemoteDataSource;

    public BookingRepository(BookingDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<BookingResponse> getBookings(int salonId, long time, int stylelistId) {
        return mRemoteDataSource.getBookings(salonId, time, stylelistId);
    }

    @Override
    public Observable<BookingResponse> getBookings(int salonId, long time) {
        return mRemoteDataSource.getBookings(salonId, time);
    }
}
