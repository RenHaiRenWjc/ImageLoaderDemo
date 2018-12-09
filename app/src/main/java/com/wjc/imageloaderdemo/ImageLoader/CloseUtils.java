package com.wjc.imageloaderdemo.ImageLoader;

import java.io.Closeable;
import java.io.IOException;

/**
 * ClassName:com.wjc.imageloaderdemo.ImageLoader
 * Description:
 * author:wjc on 2018/12/3/003 23:37
 */

public class CloseUtils {
    /**
     * 关闭 Closeable对象
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
