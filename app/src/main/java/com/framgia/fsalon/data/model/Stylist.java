package com.framgia.fsalon.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by THM on 7/20/2017.
 */
public class Stylist {
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("birthday")
    private String mBirthDay;
    @SerializedName("avatar")
    private String mAvatar;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("permission")
    private int mPermission;
    @SerializedName("experience")
    private String mExperience;
    @SerializedName("specialize")
    private String mSpecialize;
    @SerializedName("about_me")
    private String mAboutMe;
    @SerializedName("department_id")
    private int mDepartmentId;
    @SerializedName("created_at")
    private String mCreateAt;
    @SerializedName("updated_at")
    private String mUpdatedAt;

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

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getBirthDay() {
        return mBirthDay;
    }

    public void setBirthDay(String birthDay) {
        mBirthDay = birthDay;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public int getPermission() {
        return mPermission;
    }

    public void setPermission(int permission) {
        mPermission = permission;
    }

    public String getExperience() {
        return mExperience;
    }

    public void setExperience(String experience) {
        mExperience = experience;
    }

    public String getSpecialize() {
        return mSpecialize;
    }

    public void setSpecialize(String specialize) {
        mSpecialize = specialize;
    }

    public String getAboutMe() {
        return mAboutMe;
    }

    public void setAboutMe(String aboutMe) {
        mAboutMe = aboutMe;
    }

    public int getDepartmentId() {
        return mDepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        mDepartmentId = departmentId;
    }

    public String getCreateAt() {
        return mCreateAt;
    }

    public void setCreateAt(String createAt) {
        mCreateAt = createAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }
}
