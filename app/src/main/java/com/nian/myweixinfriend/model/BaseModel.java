package com.nian.myweixinfriend.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by niangang on 2016/2/1.
 */
public class BaseModel implements Parcelable {


    protected BaseModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
