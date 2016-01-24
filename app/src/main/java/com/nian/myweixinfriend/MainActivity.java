package com.nian.myweixinfriend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.title_left_button_line)
    View titleLeftButtonLine;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.img_title_camera)
    ImageView imgTitleCamera;


    @OnClick(R.id.img_back)
    void setImgBack() {
        Log.d("--NG--", "TTTTTTTTT");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ButterKnife.bind(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
