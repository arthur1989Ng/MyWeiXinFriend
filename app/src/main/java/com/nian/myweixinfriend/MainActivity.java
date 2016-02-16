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
import com.nian.myweixinfriend.adapter.MainAdapter;
import com.nian.myweixinfriend.model.ImageModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private String[][] images = new String[][]{
            {"file:///android_asset/img2.jpg", "250", "250"}
            , {"http://img3.douban.com/view/photo/photo/public/p2249526036.jpg", "640", "960"}
            , {"file:///android_asset/img3.jpg", "250", "250"}
            , {"file:///android_asset/img4.jpg", "250", "250"}
            , {"file:///android_asset/img5.jpg", "250", "250"}
            , {"file:///android_asset/img6.jpg", "250", "250"}
            , {"file:///android_asset/img7.jpg", "250", "250"}
            , {"file:///android_asset/img8.jpg", "250", "250"}
            , {"http://img4.douban.com/view/photo/photo/public/p2252689992.jpg", "1280", "800"}
    };
    private List<ArrayList<ImageModel>> imagesList;

    ImageView imgBack;
    View titleLeftButtonLine;
    TextView title;
    TextView imgTitleCamera;
    ListView list;
    RefreshLayout swipeContainer;
    private View footerLayout, headLayout;
    private TextView textMore;
    private ProgressBar progressBar;
    private MainAdapter mainAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        initView();
        initData();


        textMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMoreData();
            }
        });

        //使用SipeRefreshLayout的下拉刷新监听
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshNewData();

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


        imagesList = new ArrayList<>();
        //这里单独添加一条单条的测试数据，用来测试单张的时候横竖图片的效果
        ArrayList<ImageModel> singleList = new ArrayList<>();
        singleList.add(new ImageModel(images[8][0], Integer.parseInt(images[8][1]), Integer.parseInt(images[8][2])));
        imagesList.add(singleList);
        //从一到9生成9条朋友圈内容，分别是1~9张图片
        for (int i = 0; i < 3; i++) {
            ArrayList<ImageModel> itemList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                itemList.add(new ImageModel(images[j][0], Integer.parseInt(images[j][1]), Integer.parseInt(images[j][2])));
            }
            imagesList.add(itemList);
        }
        mainAdapter = new MainAdapter(this, imagesList);
        list.setAdapter(mainAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    private void testOne() {
        ArrayList<ImageModel> singleList = new ArrayList<>();
        singleList.add(new ImageModel(images[8][0], Integer.parseInt(images[8][1]), Integer.parseInt(images[8][2])));
        imagesList.add(singleList);
        //从一到9生成9条朋友圈内容，分别是1~9张图片
        for (int i = 0; i < 9; i++) {
            ArrayList<ImageModel> itemList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                itemList.add(new ImageModel(images[j][0], Integer.parseInt(images[j][1]), Integer.parseInt(images[j][2])));
            }
            imagesList.add(itemList);
        }
    }
}
