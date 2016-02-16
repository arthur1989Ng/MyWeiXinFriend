//package com.nian.myweixinfriend.friend;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import com.demievil.library.RefreshLayout;
//import com.nian.myweixinfriend.R;
//import com.nian.myweixinfriend.dialog.CustomDialog;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
//public class FriendActivity extends AppCompatActivity {
//
//
//    @Bind(R.id.img_back)
//    ImageView imgBack;
//    @Bind(R.id.title_left_button_line)
//    View titleLeftButtonLine;
//    @Bind(R.id.title)
//    TextView title;
//    @Bind(R.id.img_title_right)
//    TextView imgTitleCamera;
//    @Bind(R.id.list_friend)
//    ListView listFriend;
//    @Bind(R.id.swipe_container)
//    RefreshLayout swipeContainer;
//    @Bind(R.id.text_more)
//    TextView textMore;
//    @Bind(R.id.load_progress_bar)
//    ProgressBar loadProgressBar;
//    @Bind(R.id.imageView)
//    ImageView imageView;
//
//
//    private View footerLayout, headLayout;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_friend);
//        ButterKnife.bind(this);
//        Log.d("--NG--", "TTTTTTTTT");
//
//        footerLayout = getLayoutInflater().inflate(R.layout.listview_footer, null);
//        headLayout = getLayoutInflater().inflate(R.layout.listview_head, null);
//
//
//        listFriend.addFooterView(footerLayout);
//        listFriend.addHeaderView(headLayout);
//
//    }
//
//
//    @OnClick(R.id.img_back)
//    void setImgBack() {
//        Log.d("--NG--", "TTTTTTTTT");
//    }
//
//
//    @OnClick(R.id.img_title_right)
//    void showChooseDialog() {
//
//
//        CustomDialog dialog = new CustomDialog(this);
//
//        dialog.show();
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//    }
//}
