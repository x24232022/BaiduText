package com.example.administrator.baidutext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.baidutext.utils.ActivityUtils;

public class HomeActivity extends AppCompatActivity {
    private ActivityUtils mActivityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mActivityUtils=new ActivityUtils(this);
    }



}