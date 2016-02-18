package com.nian.myweixinfriend;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by niangang on 2016/2/17.
 */
public class FriendApplication extends Application {

    // 默认存放图片的路径
    public final static String DEFAULT_SAVE_IMAGE_PATH = Environment.getExternalStorageDirectory() + File.separator + "Friend" + File.separator + "Images"
            + File.separator;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initImageLoader();
    }

    public static Context getContext() {
        return mContext;
    }

    /**
     * 初始化imageLoader
     */
    private void initImageLoader() {
        DisplayImageOptions options = new DisplayImageOptions.Builder().showImageForEmptyUri(new ColorDrawable(Color.parseColor("#f5f5f5")))
                .showImageOnFail(new ColorDrawable(Color.parseColor("#f5f5f5"))).showImageOnLoading(new ColorDrawable(Color.parseColor("#f5f5f5"))).cacheInMemory(true)
                .cacheOnDisk(true).build();

        File cacheDir = new File(DEFAULT_SAVE_IMAGE_PATH);
        ImageLoaderConfiguration imageconfig = new ImageLoaderConfiguration.Builder(this)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(200)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .defaultDisplayImageOptions(options).build();

        ImageLoader.getInstance().init(imageconfig);


    }
}
