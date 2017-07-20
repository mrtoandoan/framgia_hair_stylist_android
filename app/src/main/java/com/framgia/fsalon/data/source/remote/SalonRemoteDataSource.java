package com.framgia.fsalon.data.source.remote;

import com.framgia.fsalon.data.model.Salon;
import com.framgia.fsalon.data.source.SalonDataSource;
import com.framgia.fsalon.data.source.api.FSalonApi;
import com.framgia.fsalon.utils.Utils;
import framgia.retrofitservicecreator.api.model.Respone;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by framgia on 7/20/17.
 */

public class SalonRemoteDataSource extends BaseRemoteDataSource implements SalonDataSource {

    public SalonRemoteDataSource(FSalonApi FSalonApi) {
        super(FSalonApi);
    }

    @Override
    public Observable<List<Salon>> getAllSalons() {
        return mFSalonApi.getSalon()
            .flatMap(new Func1<Respone<List<Salon>>, Observable<List<Salon>>>() {
                @Override
                public Observable<List<Salon>> call(Respone<List<Salon>> listRespone) {
                    return Utils.getResponse(listRespone);
                }
            });
    }
}
