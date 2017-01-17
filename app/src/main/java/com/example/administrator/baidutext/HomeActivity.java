package com.example.administrator.baidutext;


import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.example.administrator.baidutext.utils.ActivityUtils;



import butterknife.BindView;
import butterknife.ButterKnife;



public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.position_text_view)
    TextView positionText;
    private ActivityUtils mActivityUtils;
    public LocationClient mLocationClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mActivityUtils = new ActivityUtils(this);
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationClient());

       mLocationClient.start();


    }



    private class MyLocationClient implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            StringBuilder currentPosition = new StringBuilder();
            currentPosition.append("纬度：").append(location.getLatitude()).append("\n");
            currentPosition.append("经线：").append(location.getLongitude()).append("\n");
            currentPosition.append("定位方式:");
            //设置定位方式
            if (location.getLocType() == BDLocation.TypeGpsLocation) {
                currentPosition.append("GPS");
            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
                currentPosition.append("网络");
            }
            //将定位信息显示到屏幕上
            positionText.setText(currentPosition);
        }
    }


}
