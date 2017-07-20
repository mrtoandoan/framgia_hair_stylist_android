package com.framgia.fsalon.data.source.api;

import com.framgia.fsalon.data.model.Salon;
import com.framgia.fsalon.data.model.UserRespone;
import framgia.retrofitservicecreator.api.model.Respone;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface FSalonApi {

    @POST("api/v0/login")
    Observable<Respone<UserRespone>> login(@Query("email") String account,
        @Query("password") String passWord);

    @GET("api/v0/get-salons")
    Observable<Respone<List<Salon>>> getSalon();
}
