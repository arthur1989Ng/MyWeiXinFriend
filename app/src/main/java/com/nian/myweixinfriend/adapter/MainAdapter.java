package com.nian.myweixinfriend.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nian.myweixinfriend.R;
import com.nian.myweixinfriend.model.ImageModel;
import com.nian.myweixinfriend.utils.L;
import com.squareup.picasso.Picasso;
import com.w4lle.library.NineGridAdapter;
import com.w4lle.library.NineGridlayout;

import java.util.ArrayList;
import java.util.List;


public class MainAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private List<ArrayList<ImageModel>> datalist;
    private NineGridAdapter adapter;

    public MainAdapter(Context context, List<ArrayList<ImageModel>> datalist) {
        this.context = context;
        this.datalist = datalist;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        List<ImageModel> itemList = datalist.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_friend, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.imgFriendHead = (ImageView) convertView.findViewById(R.id.img_friend_head);
            viewHolder.imgCommit = (ImageView) convertView.findViewById(R.id.img_commit);
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.nineGridLayout = (NineGridlayout) convertView.findViewById(R.id.nine_grid_layout);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (itemList.isEmpty() || itemList.isEmpty()) {
            viewHolder.nineGridLayout.setVisibility(View.GONE);
        } else {
            viewHolder.nineGridLayout.setVisibility(View.VISIBLE);
            handlerOneImage(viewHolder, itemList);
        }

        viewHolder.imgFriendHead.setOnClickListener(this);
        viewHolder.imgCommit.setOnClickListener(this);


        return convertView;
    }

    private void handlerOneImage(ViewHolder viewHolder, final List<ImageModel> image) {
        adapter = new Adapter(context, image);
        viewHolder.nineGridLayout.setAdapter(adapter);
        viewHolder.nineGridLayout.setOnItemClickListerner(new NineGridlayout.OnItemClickListerner() {
            @Override
            public void onItemClick(View view, int position) {
                //do some thing
                L.d("onItemClick : " + image.get(position).getUrl());


            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_friend_head:
                L.d("--MG--", "img_head");


                break;
            case R.id.tv_name:
                L.d("--MG--", "tv_name");


                break;
            case R.id.img_commit:
                L.d("--MG--", "img_commit");


                break;
        }

    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_friend.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */

    class ViewHolder {
        public ImageView imgFriendHead;
        public TextView tvName;
        public TextView tvContent;
        public NineGridlayout nineGridLayout;
        public TextView tvTime;
        public ImageView imgCommit;

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
            return getItem(position) == null ? null : ((ImageModel) getItem(position)).getUrl();
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
