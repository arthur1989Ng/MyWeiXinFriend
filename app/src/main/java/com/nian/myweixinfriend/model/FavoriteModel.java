package com.nian.myweixinfriend.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by niangang on 2016/2/1.
 */
public class FavoriteModel extends BaseModel {

    private String id;
    private UserModel userModel;

    public FavoriteModel() {

    }

    public FavoriteModel(Parcel in) {
        id = in.readString();
        userModel = UserModel.CREATOR.createFromParcel(in);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserModel getUser() {
        return userModel;
    }

    public void setUser(UserModel user) {
        this.userModel = user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeParcelable(userModel, flags);
    }

    public final static Parcelable.Creator<FavoriteModel> CREATOR = new Parcelable.Creator<FavoriteModel>() {
        public FavoriteModel createFromParcel(Parcel source) {
            return new FavoriteModel(source);
        }

        public FavoriteModel[] newArray(int size) {
            return new FavoriteModel[size];
        }
    };
}
