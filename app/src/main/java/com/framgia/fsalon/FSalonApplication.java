package com.framgia.fsalon;

import android.app.Application;

import com.framgia.fsalon.data.source.api.FSalonServiceClient;

/**
 * Created by MyPC on 20/07/2017.
 */
public class FSalonApplication extends Application {
    private static FSalonApplication sInstant;

    @Override
    public void onCreate() {
        super.onCreate();
        FSalonServiceClient.initialize(this);
        sInstant = this;
    }

    public static FSalonApplication getInstant() {
        return sInstant;
    }
}
