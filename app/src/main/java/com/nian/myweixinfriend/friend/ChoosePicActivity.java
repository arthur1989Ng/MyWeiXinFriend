//package com.nian.myweixinfriend.friend;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.nian.myweixinfriend.R;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
//public class ChoosePicActivity extends AppCompatActivity {
//
//
//    @Bind(R.id.img_back)
//    ImageView imgBack;
//    @Bind(R.id.title_left_button_line)
//    View titleLeftButtonLine;
//    @Bind(R.id.title)
//    TextView title;
//    @Bind(R.id.img_title_right)
//    TextView tvTitleFinish;
//
//
//    @OnClick(R.id.img_back)
//    void setImgBack() {
//        Log.d("--NG--", "TTTTTTTTT");
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_choose_pic);
//        ButterKnife.bind(this);
//
//        init();
//    }
//
//    private void init() {
//
//        title.setText("图片");
//        tvTitleFinish.setBackground(null);
//        tvTitleFinish.setText("完成");
//
//
//    }
//
//
//    @OnClick(R.id.img_title_right)
//    void choosePicFinish() {
//
//        Log.d("--NG--", "choosePicFinish");
//    }
//
//
//    @OnClick(R.id.img_back)
//    void backToMainActivity()
//
//    {
//
//        finish();
//        Log.d("--NG--", "choosePicFinish");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//    }
//}
