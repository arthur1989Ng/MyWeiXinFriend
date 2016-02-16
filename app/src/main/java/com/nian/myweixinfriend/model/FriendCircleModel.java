package com.nian.myweixinfriend.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by niangang on 2016/2/1.
 */
public class FriendCircleModel extends BaseModel {

    private String id;
    private String content;
    private String createTime;
    private String type;  //1:链接  2:图片
    private String linkImg;
    private String linkTitle;
    private List<String> photos;
    private List<FavoriteModel> favorters;
    private List<CommentModel> comments;
    private UserModel userModel;

    public FriendCircleModel() {

    }

    public FriendCircleModel(Parcel in) {
        id = in.readString();
        content = in.readString();
        createTime = in.readString();
        type = in.readString();
        linkImg = in.readString();
        linkTitle = in.readString();
        photos = in.createStringArrayList();
        favorters = in.createTypedArrayList(FavoriteModel.CREATOR);
        comments = in.createTypedArrayList(CommentModel.CREATOR);
        userModel = UserModel.CREATOR.createFromParcel(in);
    }


    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<FavoriteModel> getFavorters() {
        return favorters;
    }

    public void setFavorters(List<FavoriteModel> favorters) {
        this.favorters = favorters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(content);
        dest.writeString(createTime);
        dest.writeString(type);
        dest.writeString(linkImg);
        dest.writeString(linkTitle);
        dest.writeStringList(photos);
        dest.writeTypedList(favorters);
        dest.writeTypedList(comments);
        userModel.writeToParcel(dest, flags);
    }

    public final static Parcelable.Creator<FriendCircleModel> CREATOR = new Parcelable.Creator<FriendCircleModel>() {
        public FriendCircleModel createFromParcel(Parcel source) {
            return new FriendCircleModel(source);
        }

        public FriendCircleModel[] newArray(int size) {
            return new FriendCircleModel[size];
        }
    };


}
