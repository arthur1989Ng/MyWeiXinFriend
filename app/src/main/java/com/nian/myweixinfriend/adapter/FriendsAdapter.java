package com.nian.myweixinfriend.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.nian.myweixinfriend.R;
import com.nian.myweixinfriend.constants.FriendCircleType;
import com.nian.myweixinfriend.model.CommentModel;
import com.nian.myweixinfriend.model.FavoriteModel;
import com.nian.myweixinfriend.model.FriendCircleModel;
import com.nian.myweixinfriend.view.MultiImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;
import com.w4lle.library.NineGridAdapter;

import java.util.ArrayList;
import java.util.List;



public class FriendsAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private ArrayList<FriendCircleModel> datalist;
    private NineGridAdapter adapter;

    public FriendsAdapter(Context context) {
        this.context = context;
    }


    public void setDatas(ArrayList<FriendCircleModel> datalist) {
        if (datalist != null) {
            this.datalist = datalist;
        }
    }

    public ArrayList<FriendCircleModel> getDatas() {

        return datalist;
    }


    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getItemViewType(int position) {
        return datalist.get(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int itemType = getItemViewType(position);


        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_friend, null);
            ViewStub linkOrImgStub = (ViewStub) convertView.findViewById(R.id.view_stub_link_or_img);
            switch (itemType) {
                case FriendCircleType.FRIEND_CIRCLE_ITEM_TYPE_IMAGE: //图片
                    linkOrImgStub.setLayoutResource(R.layout.viewstub_body_img);
                    linkOrImgStub.inflate();
                    MultiImageView multiImageView = (MultiImageView) convertView.findViewById(R.id.multi_img_view);
                    if (multiImageView != null) {
                        viewHolder.multiImageView = multiImageView;
                    }
                    break;
                case FriendCircleType.FRIEND_CIRCLE_ITEM_TYPE_LINK: //链接
                    linkOrImgStub.setLayoutResource(R.layout.viewstub_body_link);
                    linkOrImgStub.inflate();
                    LinearLayout linkLL = (LinearLayout) convertView.findViewById(R.id.ll_link);
                    if (linkLL != null) {
                        viewHolder.llLink = linkLL;
                        viewHolder.imgLink = (ImageView) linkLL.findViewById(R.id.img_link);
                        viewHolder.tvLink = (TextView) linkLL.findViewById(R.id.tv_link_content);
                    }

                    break;
            }
            viewHolder.imgHead = (ImageView) convertView.findViewById(R.id.img_friend_head);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.imgLike = (ImageView) convertView.findViewById(R.id.img_commit);
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        FriendCircleModel friendItem = datalist.get(position);


        String name = friendItem.getUserModel().getName();
        String headUrl = friendItem.getUserModel().getHeadUrl();
        String content = friendItem.getContent();
        String createTime = friendItem.getCreateTime();

        List<FavoriteModel> favoriteModels = friendItem.getFavorters();
        List<CommentModel> commentModels = friendItem.getComments();

        viewHolder.tvTime.setText(friendItem.getId());
        viewHolder.tvName.setText(friendItem.getUserModel().getName());

        Picasso.with(context).load(headUrl).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5"))).into(viewHolder.imgHead);


        switch (itemType) {
            case FriendCircleType.FRIEND_CIRCLE_ITEM_TYPE_IMAGE: //图片
                if (viewHolder.multiImageView != null) {
                    List<String> imageModels = friendItem.getPhotos();
                    if (imageModels != null || imageModels.size() > 0) {
                        viewHolder.multiImageView.setVisibility(View.VISIBLE);
                        viewHolder.multiImageView.setList(imageModels);
                    } else {
                        viewHolder.multiImageView.setVisibility(View.GONE);
                        Log.d("--NG--", "   viewHolder.multiImageView.setVisibility(View.GONE) ");

                    }
                } else {
                    Log.d("--NG--", "get View Null -- FRIEND_CIRCLE_ITEM_TYPE_IMAGE ");

                }
                break;
            case FriendCircleType.FRIEND_CIRCLE_ITEM_TYPE_LINK:
                if (viewHolder.llLink != null) {
                    String linkStr = friendItem.getLinkTitle();
                    String linkImgUrl = friendItem.getLinkImg();

                    viewHolder.llLink.setVisibility(View.VISIBLE);
                    ImageLoader.getInstance().displayImage(linkImgUrl, viewHolder.imgLink);
                    viewHolder.tvLink.setText(linkStr);
                } else {
                    Log.d("--NG--", "get View Null -- FRIEND_CIRCLE_ITEM_TYPE_LINK ");
                }
                break;

        }
        return convertView;
    }


    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.img_friend_head:
//                L.d("--MG--", "img_head");
//
//
//                break;
//            case R.id.tv_name:
//                L.d("--MG--", "tv_name");
//
//
//                break;
//            case R.id.img_commit:
//                L.d("--MG--", "img_commit");
//
//
//                break;
//        }

    }



    class ViewHolder {
        public ImageView imgHead;
        public TextView tvName;

        // 地址
        public TextView tvAddr;
        //时间显示
        public TextView tvTime;

        //评论键
        public ImageView imgCommit;
        //评论窗
        public PopupWindow commitPopupWindow;


        //根据朋友圈的类型 展示不同的内容

        // 图片
        public MultiImageView multiImageView;
        //赞
        public ImageView imgLike;


        // 链接 [图片 文字 ]
        public LinearLayout llLink;
        public ImageView imgLink;
        public TextView tvLink;


        //点赞列表
        // ListView

        //


    }


    class Adapter extends NineGridAdapter {

        public Adapter(Context context, List list) {
            super(context, list);
        }

        @Override
        public int getCount() {
            return (list == null) ? 0 : list.size();
        }

        @Override
        public String getUrl(int position) {
            return list.get(position).toString();
        }

        @Override
        public Object getItem(int position) {
            return (list == null) ? null : list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view) {
            ImageView iv = null;
            if (view != null && view instanceof ImageView) {
                iv = (ImageView) view;
            } else {
                iv = new ImageView(context);
            }
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setBackgroundColor(context.getResources().getColor((android.R.color.transparent)));
            String url = getUrl(i);
            Picasso.with(context).load(getUrl(i)).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5"))).into(iv);
            if (!TextUtils.isEmpty(url)) {
                iv.setTag(url);
            }
            return iv;
        }
    }


}
