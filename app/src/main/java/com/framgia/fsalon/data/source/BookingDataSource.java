package com.framgia.fsalon.data.source;

import com.framgia.fsalon.data.model.BookingResponse;
import java.util.List;
import rx.Observable;

/**
 * Created by framgia on 7/21/17.
 */

public interface BookingDataSource {

    Observable<BookingResponse> getBookings(int salonId, long time, int stylelistId);

    Observable<BookingResponse> getBookings(int salonId, long time);
}
