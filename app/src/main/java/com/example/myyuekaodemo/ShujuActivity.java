package com.example.myyuekaodemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;


public class ShujuActivity extends AppCompatActivity {

    private RecyclerView rv;
    private MyBean[] myBeans;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){



        @Override
        public void handleMessage(Message msg) {
            String str = (String) msg.obj;
            Gson gson = new Gson();
            myBeans = gson.fromJson(str, MyBean[].class);
            Log.e("namebb",str);
            rv.setLayoutManager(new LinearLayoutManager(ShujuActivity.this,LinearLayoutManager.VERTICAL,false));
            MyRecyclerAdapter adapter = new MyRecyclerAdapter(myBeans,ShujuActivity.this);
            rv.setAdapter(adapter);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuju);
        initView();
        initData();
    }

    private void initData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = MyOkHttp.getMyOkHttp().sendGet("http://172.16.45.24/aaxx.txt");
                    handler.obtainMessage(100,s).sendToTarget();
                    Log.e("nameaa",s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
    }
}
