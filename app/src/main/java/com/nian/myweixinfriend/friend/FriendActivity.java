package com.nian.myweixinfriend.friend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nian.myweixinfriend.R;
import com.nian.myweixinfriend.dialog.CustomDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FriendActivity extends AppCompatActivity {


    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.title_left_button_line)
    View titleLeftButtonLine;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.img_title_right)
    TextView imgTitleCamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ButterKnife.bind(this);


    }


    @OnClick(R.id.img_back)
    void setImgBack() {
        Log.d("--NG--", "TTTTTTTTT");
    }


    @OnClick(R.id.img_title_right)
    void showChooseDialog() {


        CustomDialog dialog = new CustomDialog(this);

        dialog.show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
