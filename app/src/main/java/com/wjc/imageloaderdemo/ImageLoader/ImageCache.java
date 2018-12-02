package com.wjc.imageloaderdemo.ImageLoader;

import android.graphics.Bitmap;

/**
 * ClassName:com.wjc.imageloaderdemo.ImageLoader
 * Description:
 * author:wjc on 2018/11/30/030 00:28
 */

public interface ImageCache {
    Bitmap get(String url);

    void put(String url, Bitmap bitmap);
}
