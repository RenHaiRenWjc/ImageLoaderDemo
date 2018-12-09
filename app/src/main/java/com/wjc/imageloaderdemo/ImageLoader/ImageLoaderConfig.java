package com.wjc.imageloaderdemo.ImageLoader;

/**
 * ClassName:com.wjc.imageloaderdemo.ImageLoader
 * Description:
 * author:wjc on 2018/12/9/009 16:10
 */

public class ImageLoaderConfig {

    ImageCache bitmapCache = new MemoryCache();
    private DisPlayConfig disPlayConfig = new DisPlayConfig();
    private LoadPolicy loadPolicy = new LoadPolicy();
    private int threadCount = Runtime.getRuntime().availableProcessors() + 1;

    public static class Builder {
        ImageCache bitmapCache = new MemoryCache();
        DisPlayConfig disPlayConfig = new DisPlayConfig();
        LoadPolicy loadPolicy = new LoadPolicy();
        int threadCount = Runtime.getRuntime().availableProcessors() + 1;

        public Builder setThreadCount(int count) {
            threadCount = Math.max(1, count);
            return this;
        }

        public Builder setCache(ImageCache cache) {
            bitmapCache = cache;
            return this;
        }

        public Builder setLoadingPlaceholder(int resId) {
            disPlayConfig.loadingResId = resId;
            return this;
        }

        public Builder setNotFountPlaceholder(int resId) {
            disPlayConfig.failedResId = resId;
            return this;
        }

        public Builder setLoadPolicy(LoadPolicy policy) {
            if (policy != null) {
                loadPolicy = policy;
            }
            return this;
        }

        private void applyConfig(ImageLoaderConfig config) {
            config.bitmapCache = this.bitmapCache;
            config.disPlayConfig = this.disPlayConfig;
            config.loadPolicy = this.loadPolicy;
            config.threadCount = this.threadCount;
        }

        public ImageLoaderConfig create() {
            ImageLoaderConfig config = new ImageLoaderConfig();
            applyConfig(config);
            return config;
        }
    }


}
