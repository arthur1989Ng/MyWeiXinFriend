package com.nian.myweixinfriend;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.demievil.library.RefreshLayout;
import com.nian.myweixinfriend.adapter.FriendsAdapter;
import com.nian.myweixinfriend.model.FavoriteModel;
import com.nian.myweixinfriend.model.FriendCircleModel;
import com.nian.myweixinfriend.model.ImageModel;
import com.nian.myweixinfriend.utils.DatasUtil;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ArrayList<FriendCircleModel> imagesList;

    ImageView imgBack;
    View titleLeftButtonLine;
    TextView title;
    TextView imgTitleCamera;
    ListView list;
    RefreshLayout swipeContainer;
    private View footerLayout, headLayout;
    private TextView textMore;
    private ProgressBar progressBar;
    private FriendsAdapter mainAdapter;
    private ArrayList<FriendCircleModel> datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        initView();
        initData();


    }


    private void initView() {
        list = (ListView) findViewById(R.id.list_friend);
        swipeContainer = (RefreshLayout) findViewById(R.id.swipe_container);
        headLayout = getLayoutInflater().inflate(R.layout.listview_head, null);
        footerLayout = getLayoutInflater().inflate(R.layout.listview_footer, null);

        textMore = (TextView) footerLayout.findViewById(R.id.text_more);
        progressBar = (ProgressBar) footerLayout.findViewById(R.id.load_progress_bar);

        list.addHeaderView(headLayout);
        list.addFooterView(footerLayout);

        swipeContainer.setChildView(list);

        swipeContainer.setColorSchemeResources(R.color.google_blue,
                R.color.google_green,
                R.color.google_red,
                R.color.google_yellow);


    }


    private void refreshNewData() {

        // 刷新新的数据 耗时操作
        swipeContainer.setRefreshing(false);


    }


    private void loadMoreData() {
        textMore.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                testOne();
                swipeContainer.setLoading(false);
                mainAdapter.notifyDataSetChanged();
                textMore.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Refresh Finished!", Toast.LENGTH_SHORT).show();
            }
        }, 2000);


    }


    private void initData() {

        datas = DatasUtil.createCircleDatas();
        mainAdapter = new FriendsAdapter(this);
        mainAdapter.setDatas(datas);
        list.setAdapter(mainAdapter);


        textMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                loadMoreData();
            }
        });

        //使用SipeRefreshLayout的下拉刷新监听
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                refreshNewData();

            }
        });


        //使用自定义的RefreshLayout加载更多监听
        //use customed RefreshLayout OnLoadListener
        swipeContainer.setOnLoadListener(new RefreshLayout.OnLoadListener() {
            @Override
            public void onLoad() {
                loadMoreData();
            }
        });
    }


    public void testOne() {
        datas = DatasUtil.createCircleDatas();
    }

}