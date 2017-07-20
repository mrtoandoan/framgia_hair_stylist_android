package com.framgia.fsalon.data.source.api;

import com.framgia.fsalon.data.model.UserRespone;

import framgia.retrofitservicecreator.api.model.Respone;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface FSalonApi {
    @POST("api/v0/login")
    Observable<Respone<UserRespone>> login(@Query("email") String account, @Query("password")
        String passWord);
}
