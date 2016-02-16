package com.nian.myweixinfriend.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by niangang on 2016/2/1.
 */
public class UserModel extends BaseModel {
    private String id;
    private String name;
    private String headUrl;

    public UserModel() {
        // TODO Auto-generated constructor stub
    }


    public UserModel(Parcel in) {

        id = in.readString();
        name = in.readString();
        headUrl = in.readString();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(headUrl);
    }


    public final static Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
