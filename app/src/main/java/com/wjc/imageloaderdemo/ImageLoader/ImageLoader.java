package com.wjc.imageloaderdemo.ImageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:com.wjc.imageloaderdemo
 * Description:图片下载并缓存
 * author:wjc on 2018/11/29/029 22:41
 */

public class ImageLoader {
    private static ImageLoader sInstance;
    private ImageCache mImageCache = new MemoryCache();
    ExecutorService mES;

    private ImageLoader() {
    }

    /**
     * DCL 形式
     *
     * @return ImageLoader
     */
    public static ImageLoader Instance() {
        if (sInstance == null) {
            synchronized (ImageLoader.class) {
                if (sInstance == null) {
                    sInstance = new ImageLoader();
                }
            }
        }
        return sInstance;
    }

    public void init(ImageLoaderConfig config) {
        mImageCache = config.bitmapCache;
        mES = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void setImageCache(ImageCache imageCache) {
        this.mImageCache = imageCache;
    }

    public void disPlayImage(final String imageUrl, final ImageView imageView) {
        Bitmap bitmap = mImageCache.get(imageUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        //没有缓存，去下载
        submitLoadRequest(imageUrl, imageView);

    }

    private void submitLoadRequest(final String imageUrl, final ImageView imageView) {
        imageView.setTag(imageUrl);
        mES.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(imageUrl);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(imageUrl)) {
                    imageView.setImageBitmap(bitmap);
                    mImageCache.put(imageUrl, bitmap);
                }
            }
        });
    }


    public Bitmap downloadImage(String imgUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imgUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
