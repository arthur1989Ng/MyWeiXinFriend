package com.nian.myweixinfriend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nian.myweixinfriend.library.RefreshLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private View headerLayout, footerLayout;


    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.title_left_button_line)
    View titleLeftButtonLine;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.img_title_right)
    TextView imgTitleCamera;
    @Bind(R.id.list)
    ListView list;
    @Bind(R.id.swipe_container)
    RefreshLayout swipeContainer;


    @OnClick(R.id.img_back)
    void setImgBack() {
        Log.d("--NG--", "TTTTTTTTT");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ButterKnife.bind(this);


        headerLayout = getLayoutInflater().inflate(R.layout.listview_head, null);
        footerLayout = getLayoutInflater().inflate(R.layout.listview_footer, null);
        list.addHeaderView(headerLayout);
        list.addFooterView(footerLayout);

        swipeContainer.setChildView(list);

        swipeContainer.setColorSchemeResources(R.color.google_blue,
                R.color.google_green,
                R.color.google_red,
                R.color.google_yellow);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
