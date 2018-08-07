package com.example.chenhaoqiang.test.schema;

import android.content.Context;
import android.net.Uri;

import com.example.chenhaoqiang.test.viewpager.ViewPagerActivity;

/**
 * scheme学习
 * uri的格式：
 *    [scheme:]scheme-specific-part[#fragment]
 *    [scheme:][//authority][path][?query][#fragment]
 *    [scheme:][//host:port][path][?query][#fragment]
 *
 *@author chenhaoqiang
 *@date 2018/8/6
 */
public class SchemaHelper {
    private static final String SCHEME = "aiknow";
    private static final String HOST = "viewpager";

    private Context context;

    public SchemaHelper(Context context) {
        this.context = context;
    }

    public void doJump(Uri uri){
        if (uri.getScheme().equals(SCHEME)){
            if (uri.getHost().equals(HOST)){
                ViewPagerActivity.launch(context);
            }
        }
    }
}
