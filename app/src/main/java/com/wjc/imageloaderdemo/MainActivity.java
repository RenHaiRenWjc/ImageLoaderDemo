package com.wjc.imageloaderdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.wjc.imageloaderdemo.ImageLoader.ImageCache;
import com.wjc.imageloaderdemo.ImageLoader.ImageLoader;

public class MainActivity extends AppCompatActivity {
    String url = "http://imgcache.qq.com/fm/photo/album/rmid_album_360/b/C/0002Dl6Q1ZEwbC.jpg?time=1532223128";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.iv);
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.disPlayImage(url, imageView);
        imageLoader.setImageCache(new ImageCache() {
            @Override
            public Bitmap get(String url) {
                return null;
            }

            @Override
            public void put(String url, Bitmap bitmap) {

            }
        });

    }
}
