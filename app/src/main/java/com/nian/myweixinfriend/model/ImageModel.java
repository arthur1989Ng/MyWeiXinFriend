package com.nian.myweixinfriend.model;


import android.os.Parcel;
import android.os.Parcelable;

public class ImageModel extends BaseModel {
    private String url;
    private int width;
    private int height;

    public ImageModel(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }


    public ImageModel(Parcel in) {

        url = in.readString();
        width = in.readInt();
        height = in.readInt();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeInt(width);
        dest.writeInt(height);
    }


    public final static Parcelable.Creator<ImageModel> CREATOR = new Parcelable.Creator<ImageModel>() {
        public ImageModel createFromParcel(Parcel source) {
            return new ImageModel(source);
        }

        public ImageModel[] newArray(int size) {
            return new ImageModel[size];
        }
    };
}
