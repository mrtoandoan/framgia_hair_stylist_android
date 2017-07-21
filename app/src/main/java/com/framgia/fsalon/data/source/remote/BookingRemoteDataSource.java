package com.framgia.fsalon.data.source.remote;

import com.framgia.fsalon.data.model.BookingResponse;
import com.framgia.fsalon.data.source.BookingDataSource;
import com.framgia.fsalon.data.source.api.FSalonApi;
import com.framgia.fsalon.utils.Utils;
import framgia.retrofitservicecreator.api.model.Respone;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;

import static com.framgia.fsalon.utils.Constant.ApiParram.DATE;
import static com.framgia.fsalon.utils.Constant.ApiParram.DEPARTMENT_ID;
import static com.framgia.fsalon.utils.Constant.ApiParram.STYLIST_ID;

/**
 * Created by framgia on 7/21/17.
 */

public class BookingRemoteDataSource extends BaseRemoteDataSource implements BookingDataSource {

    public BookingRemoteDataSource(FSalonApi FSalonApi) {
        super(FSalonApi);
    }

    @Override
    public Observable<BookingResponse> getBookings(int salonId, long time, int stylelistId) {
        Map<String, String> parram = new HashMap<>();
        parram.put(DEPARTMENT_ID, String.valueOf(salonId));
        parram.put(DATE, String.valueOf(time));
        if (stylelistId != -1) {
            parram.put(STYLIST_ID, String.valueOf(stylelistId));
        }
        return mFSalonApi.getBookings(parram)
            .flatMap(new Func1<Respone<BookingResponse>, Observable<BookingResponse>>() {

                @Override
                public Observable<BookingResponse> call(
                    Respone<BookingResponse> bookingResponseRespone) {
                    return Utils.getResponse(bookingResponseRespone);
                }
            });
    }

    @Override
    public Observable<BookingResponse> getBookings(int salonId, long time) {
        return getBookings(salonId, time, -1);
    }
}
