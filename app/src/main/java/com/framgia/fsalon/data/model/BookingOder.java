package com.framgia.fsalon.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by framgia on 7/21/17.
 */

public class BookingOder {

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
    private Date mpdatedAt;
    @SerializedName("status")
    @Expose
    private int mStatus;
}
