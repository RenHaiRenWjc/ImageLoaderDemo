package com.wjc.imageloaderdemo;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * ClassName:com.wjc.imageloaderdemo
 * Description:
 * author:wjc on 2018/11/29/029 23:11
 */

public class ImageCache {

    private LruCache<String, Bitmap> mImageCache;

    public ImageCache() {
        initImageCache();
    }

    private void initImageCache() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap);
    }

    public void get(String url) {
        mImageCache.get(url);
    }
}
