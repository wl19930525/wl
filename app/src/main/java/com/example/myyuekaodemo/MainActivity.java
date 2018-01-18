package com.example.myyuekaodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.amap.api.maps.model.animation.AlphaAnimation;
import com.amap.api.maps.model.animation.Animation;

public class MainActivity extends AppCompatActivity {
    private ImageView imagea;

//再见2017，拒绝遗憾，迎战2018，拥抱希望，我是物联网专业1706A班 王磊


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        AlphaAnimation alphaanimation = new AlphaAnimation(1.0f,0.1f);

        alphaanimation.setDuration(2000);




    }


    private void initView()
    {
        imagea = (ImageView) findViewById(R.id.imagea);
    }
}

