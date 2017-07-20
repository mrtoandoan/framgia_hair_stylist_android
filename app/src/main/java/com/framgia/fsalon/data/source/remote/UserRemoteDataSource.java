package com.framgia.fsalon.data.source.remote;

import com.framgia.fsalon.data.source.UserDataSource;
import com.framgia.fsalon.data.model.UserRespone;
import com.framgia.fsalon.data.source.api.FSalonApi;
import com.framgia.fsalon.utils.Utils;

import framgia.retrofitservicecreator.api.model.Respone;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by MyPC on 20/07/2017.
 */
public class UserRemoteDataSource extends BaseRemoteDataSource
    implements UserDataSource.RemoteDataSource {
    public UserRemoteDataSource(FSalonApi FSalonApi) {
        super(FSalonApi);
    }

    @Override
    public Observable<UserRespone> login(String account, String passWord) {
        return mFSalonApi.login(account, passWord).flatMap(
            new Func1<Respone<UserRespone>, Observable<UserRespone>>() {
                @Override
                public Observable<UserRespone> call(Respone<UserRespone> userResponeRespone) {
                    return Utils.getResponse(userResponeRespone);
                }
            });
    }
}
