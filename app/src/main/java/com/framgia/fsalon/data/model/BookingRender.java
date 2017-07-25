package com.framgia.fsalon.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.framgia.fsalon.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.framgia.fsalon.utils.Constant.AVAILABLE;
import static com.framgia.fsalon.utils.Constant.FULL;
import static com.framgia.fsalon.utils.Constant.OFF_WORK;

/**
 * Created by framgia on 7/21/17.
 */
public class BookingRender extends BaseObservable{
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("day")
    @Expose
    private String mDay;
    @SerializedName("time_start")
    @Expose
    private String mTimeStart;
    @SerializedName("total_slot")
    @Expose
    private int mTotalSlot;
    @SerializedName("status")
    @Expose
    private int mStatus;
    @SerializedName("department_id")
    @Expose
    private int mDepartmentId;
    @SerializedName("created_at")
    @Expose
    private String mCreatedAt;
    @SerializedName("updated_at")
    @Expose
    private String mUpdatedAt;
    @SerializedName("statusLabel")
    @Expose
    private String mStatusLabel;
    @SerializedName("order_booking")
    @Expose
    private List<BookingOder> mOrderBooking;

    @Bindable
    public int getResourceId() {
        switch (mStatus) {
            case FULL:
                return R.drawable.bg_border_red;
            case AVAILABLE:
                return R.drawable.bg_border_green;
            case OFF_WORK:
                return R.drawable.bg_border_red;
            default:
                return R.drawable.bg_border_green;
        }
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getDay() {
        return mDay;
    }

    public void setDay(String day) {
        mDay = day;
    }

    public String getTimeStart() {
        return mTimeStart;
    }

    public void setTimeStart(String timeStart) {
        mTimeStart = timeStart;
    }

    public int getTotalSlot() {
        return mTotalSlot;
    }

    public void setTotalSlot(int totalSlot) {
        mTotalSlot = totalSlot;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public int getDepartmentId() {
        return mDepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        mDepartmentId = departmentId;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getStatusLabel() {
        return mStatusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        mStatusLabel = statusLabel;
    }

    public List<BookingOder> getOrderBooking() {
        return mOrderBooking;
    }

    public void setOrderBooking(List<BookingOder> orderBooking) {
        mOrderBooking = orderBooking;
    }
}
