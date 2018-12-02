package com.wjc.imageloaderdemo.ImageLoader;

import android.graphics.Bitmap;

/**
 * ClassName:com.wjc.imageloaderdemo.ImageLoader
 * Description:
 * author:wjc on 2018/12/1/001 19:32
 */

public class DoubleCache implements ImageCache {
    ImageCache mMemoryCache = new MemoryCache();
    ImageCache mDisCache = new DisCache();

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDisCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        mDisCache.put(url, bitmap);
    }
}
