package com.example.administrator.baidutext;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.baidutext.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogoActivity extends AppCompatActivity {
    @BindView(R.id.iv_activity_logo)
    ImageView mIv_logo;
    @BindView(R.id.btn_start_activity_logo)
    Button mBtb_start_logo;
    private ActivityUtils mActivityUtils;

    private int leftTime = 3;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    if (leftTime > 0) {
                        String newText = "跳过(" + leftTime-- + "s)";
                        mBtb_start_logo.setText(newText);
                        handler.sendEmptyMessageDelayed(0, 1000);
                    } else {
                        mActivityUtils.startActivity(HomeActivity.class);
                        finish();
                    }

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        ButterKnife.bind(this);
        mActivityUtils = new ActivityUtils(this);
        mBtb_start_logo.setVisibility(View.GONE);
        Animation logoAnimation= AnimationUtils.loadAnimation(this,R.anim.animation);
        mIv_logo.setAnimation(logoAnimation);
        logoAnimation.start();
        logoAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                mBtb_start_logo.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        handler.sendEmptyMessageAtTime(0,1000);
    }

    @OnClick(R.id.btn_start_activity_logo)
    public void onClick() {
        mActivityUtils.startActivity(HomeActivity.class);
        handler.removeMessages(0);
        LogoActivity.this.finish();
    }
}
