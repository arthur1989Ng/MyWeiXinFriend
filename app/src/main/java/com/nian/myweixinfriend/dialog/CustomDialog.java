//package com.nian.myweixinfriend.dialog;
//
//import android.app.Activity;
//import android.app.Dialog;
//import android.content.Context;
//import android.content.Intent;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.View;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.nian.myweixinfriend.R;
//import com.nian.myweixinfriend.friend.ChoosePicActivity;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
///**
// * Created by niangang on 2016/1/24.
// */
//public class CustomDialog extends Dialog {
//
//    @Bind(R.id.ll_dialog_camera)
//    LinearLayout llDialogCamera;
//    @Bind(R.id.ll_dialog_video)
//    LinearLayout llDialogVideo;
//
//
//    private Context mContext;
//    protected View mRootView;
//    private float mDensity;
//
//    public CustomDialog(Context context) {
//        super(context);
//
//        mContext = context;
//        init();
//
//    }
//
//    public CustomDialog(Context context, int themeResId) {
//        super(context, themeResId);
//        mContext = context;
//        init();
//
//    }
//
//    private final void init() {
//        getContext().setTheme(R.style.dialog);
//        super.setContentView(R.layout.custom_dialog);
//
//        mRootView = findViewById(R.id.root);
//        ButterKnife.bind(this, mRootView);
//        DisplayMetrics metric = new DisplayMetrics();
//        try {
//            ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(metric);
//        } catch (Exception e) {
//        }
//        int width = Math.min(metric.widthPixels, metric.heightPixels);
//        mDensity = metric.density == 0 ? 1.5f : metric.density;
//        width -= 20 * mDensity;
//        mRootView.getLayoutParams().width = width;
//
//        setCanceledOnTouchOutside(true);
//    }
//
//    @OnClick(R.id.ll_dialog_camera)
//    void showPicChooseActivity() {
//
//        Log.d("--NG--", "showPicChooseActivity ");
//
//        Intent cIntent = new Intent(mContext, ChoosePicActivity.class);
//        mContext.startActivity(cIntent);
//        dismiss();
//
//    }
//
//
//}
