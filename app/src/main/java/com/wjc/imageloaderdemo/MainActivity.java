package com.wjc.imageloaderdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.wjc.imageloaderdemo.ImageLoader.DoubleCache;
import com.wjc.imageloaderdemo.ImageLoader.ImageLoader;
import com.wjc.imageloaderdemo.ImageLoader.ImageLoaderConfig;
import com.wjc.imageloaderdemo.ImageLoader.LoadPolicy;

public class MainActivity extends AppCompatActivity {
    String url = "http://imgcache.qq.com/fm/photo/album/rmid_album_360/b/C/0002Dl6Q1ZEwbC.jpg?time=1532223128";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.iv);
        ImageLoaderConfig config = new ImageLoaderConfig.Builder().setLoadingPlaceholder(R.drawable.ic_launcher_background)
                .setNotFountPlaceholder(R.drawable.ic_launcher_background).setCache(new DoubleCache())
                .setThreadCount(4).setLoadPolicy(new LoadPolicy())
                .create();
        ImageLoader.getInstance().init(config);
    }
}
