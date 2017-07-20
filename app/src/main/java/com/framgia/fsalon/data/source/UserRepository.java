package com.framgia.fsalon.data.source;

import com.framgia.fsalon.data.model.UserRespone;
import com.framgia.fsalon.data.source.remote.UserRemoteDataSource;

import rx.Observable;

/**
 * Created by MyPC on 20/07/2017.
 */
public class UserRepository implements UserDataSource.RemoteDataSource {
    private UserRemoteDataSource mUserRemoteDataSource;

    public UserRepository(UserRemoteDataSource userRemoteDataSource) {
        mUserRemoteDataSource = userRemoteDataSource;
    }

    @Override
    public Observable<UserRespone> login(String account, String passWord) {
        return mUserRemoteDataSource.login(account, passWord);
    }
}
