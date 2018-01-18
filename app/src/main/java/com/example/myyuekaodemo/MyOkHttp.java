package com.example.myyuekaodemo;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lvxinxin on 2017/12/19.
 * OKHTTP工具类
 * 加入缓存
 */

public class MyOkHttp {
    private static MyOkHttp myOkHttp = new MyOkHttp();
    private OkHttpClient okHttpClient;
    private Cache cache;
    private long maxSize = 8 * 1024 * 1024;

    private MyOkHttp() {
        //Environment用来管理手机SDcard内存的
        File file = new File(Environment.getExternalStorageDirectory() + "/H1706A");
        cache = new Cache(file, maxSize);
        //OKHTTPClient两种写法 第二种就是通过构造者模式也可以使用
        okHttpClient = new OkHttpClient.Builder().cache(cache).build();

    }

    public static MyOkHttp getMyOkHttp() {
        return myOkHttp;
    }

    //同步下get，Post
    public String sendGet(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }



    //测试缓存
    public String sendCacheGet(String url) throws IOException {
        //要缓存数据  需要加上一个方法cacheControl
        Request request = new Request.Builder().url(url).cacheControl(new CacheControl.Builder().maxStale(24 * 60 * 60, TimeUnit.SECONDS).build()).build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }
}
