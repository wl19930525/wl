package com.example.myyuekaodemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.io.IOException;
import java.util.List;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lv;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String str = (String) msg.obj;
            Gson gson = new Gson();
            Mydata mydata = gson.fromJson(str, Mydata.class);
            List<String> color = mydata.getColor();
            List<String> beaner = mydata.getBeaner();
            List<Mydata.SizeBean> size = mydata.getSize();



        }
    };
    private Button but_fenx;
    private ImageView Image233;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        initView();
        initData();

    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = MyOkHttp.getMyOkHttp().sendGet("http://172.16.45.14/xiangqing.json");
                    handler.obtainMessage(100, s).sendToTarget();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initView() {

        but_fenx = (Button) findViewById(R.id.but_fenx);
        but_fenx.setOnClickListener(this);
        Image233 = (ImageView) findViewById(R.id.Image233);
        Image233.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_fenx:
                UMImage image = new UMImage(ContentActivity.this, R.drawable.dir3);
                new ShareAction(ContentActivity.this)
                        .withText("hello")
                        .withMedia(image)
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener)
                        .open();
                break;
        }

    }

    UMShareListener shareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调，可以用来处理等待框，或相关的文字提示
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
        }
    };


}
