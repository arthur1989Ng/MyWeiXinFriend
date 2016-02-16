package com.nian.myweixinfriend.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by niangang on 2016/2/1.
 */
public class CommentModel extends BaseModel {

    private String id;
    private UserModel user;
    private UserModel toReplyUser;
    private String content;


    public CommentModel() {

    }

    public CommentModel(Parcel in) {
        id = in.readString();
        user = UserModel.CREATOR.createFromParcel(in);
        toReplyUser = UserModel.CREATOR.createFromParcel(in);
        content = in.readString();
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserModel getToReplyUser() {
        return toReplyUser;
    }

    public void setToReplyUser(UserModel toReplyUser) {
        this.toReplyUser = toReplyUser;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(id);
        dest.writeParcelable(user, flags);
        dest.writeParcelable(toReplyUser, flags);
        dest.writeString(content);
    }

    public static final Parcelable.Creator<CommentModel> CREATOR = new Parcelable.Creator<CommentModel>() {
        public CommentModel createFromParcel(Parcel source) {
            return new CommentModel(source);
        }

        public CommentModel[] newArray(int size) {
            return new CommentModel[size];
        }
    };

}
