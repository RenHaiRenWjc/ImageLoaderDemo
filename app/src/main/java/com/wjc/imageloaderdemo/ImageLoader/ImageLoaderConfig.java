package com.wjc.imageloaderdemo.ImageLoader;

/**
 * ClassName:com.wjc.imageloaderdemo.ImageLoader
 * Description:
 * author:wjc on 2018/12/9/009 16:10
 */

public class ImageLoaderConfig {

    public ImageCache bitmapCache;
    public int threadCount;

    public ImageLoaderConfig(ImageCache bitmapCache, int threadCount) {
        this.bitmapCache = bitmapCache;
        this.threadCount = threadCount;
    }
}
