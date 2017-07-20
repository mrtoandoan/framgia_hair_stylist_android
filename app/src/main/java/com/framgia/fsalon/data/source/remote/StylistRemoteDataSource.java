package com.framgia.fsalon.data.source.remote;

import com.framgia.fsalon.data.model.Stylist;
import com.framgia.fsalon.data.source.StylistDataSource;
import com.framgia.fsalon.data.source.api.FSalonApi;
import com.framgia.fsalon.utils.Utils;

import java.util.List;

import framgia.retrofitservicecreator.api.model.Respone;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by THM on 7/20/2017.
 */
public class StylistRemoteDataSource extends BaseRemoteDataSource implements StylistDataSource {
    public StylistRemoteDataSource(FSalonApi FSalonApi) {
        super(FSalonApi);
    }

    @Override
    public Observable<List<Stylist>> getAllStylists(int id) {
        return mFSalonApi.getStylistBySalonId(id).
            flatMap(
                new Func1<Respone<List<Stylist>>, Observable<List<Stylist>>>() {
                    @Override
                    public Observable<List<Stylist>> call(Respone<List<Stylist>> listRespone) {
                        return Utils.getResponse(listRespone);
                    }
                });
    }
}
