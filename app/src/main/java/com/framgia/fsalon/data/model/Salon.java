package com.framgia.fsalon.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by framgia on 7/20/17.
 */

public class Salon {

    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("address")
    @Expose
    private String mAddress;

    public Salon(String name, String address) {
        mName = name;
        mAddress = address;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }
}
