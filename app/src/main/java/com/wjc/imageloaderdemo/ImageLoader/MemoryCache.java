package com.wjc.imageloaderdemo.ImageLoader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * ClassName:com.wjc.imageloaderdemo
 * Description:
 * author:wjc on 2018/11/29/029 23:11
 */

public class MemoryCache implements ImageCache {

    private LruCache<String, Bitmap> mImageCache;

    public MemoryCache() {
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

    @Override
    public Bitmap get(String url) {
        return mImageCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap);
    }

}
