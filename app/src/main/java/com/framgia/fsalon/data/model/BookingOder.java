package com.framgia.fsalon.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by framgia on 7/21/17.
 */

public class BookingOder implements Serializable {

    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("render_booking_id")
    @Expose
    private int mRenderBookingId;
    @SerializedName("user_id")
    @Expose
    private int mUserId;
    @SerializedName("phone")
    @Expose
    private String mPhone;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("stylist_id")
    @Expose
    private int mStylistId;
    @SerializedName("grand_total")
    @Expose
    private int mGandTotal;
    @SerializedName("created_at")
    @Expose
    private Date mCreatedAt;
    @SerializedName("updated_at")
    @Expose
    private Date mUpdatedAt;
    @SerializedName("status")
    @Expose
    private int mStatus;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getRenderBookingId() {
        return mRenderBookingId;
    }

    public void setRenderBookingId(int renderBookingId) {
        mRenderBookingId = renderBookingId;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getStylistId() {
        return mStylistId;
    }

    public void setStylistId(int stylistId) {
        mStylistId = stylistId;
    }

    public int getGandTotal() {
        return mGandTotal;
    }

    public void setGandTotal(int gandTotal) {
        mGandTotal = gandTotal;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
    }

    public Date getMpdatedAt() {
        return mUpdatedAt;
    }

    public void setMpdatedAt(Date mpdatedAt) {
        this.mUpdatedAt = mpdatedAt;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }
}
