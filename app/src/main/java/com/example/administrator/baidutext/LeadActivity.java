package com.example.administrator.baidutext;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.baidutext.utils.ActivityUtils;
import com.example.administrator.baidutext.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeadActivity extends AppCompatActivity {
    @BindView(R.id.viewpager_activity_lead)
    ViewPager mVp_lead;
    @BindView(R.id.iv_lead_activity_1)
    ImageView mIv_lead_1;
    @BindView(R.id.iv_lead_activity_2)
    ImageView mIv_lead_2;
    @BindView(R.id.iv_lead_activity_3)
    ImageView mIv_lead_3;
    @BindView(R.id.iv_lead_activity_4)
    ImageView mIv_lead_4;
    @BindView(R.id.start_run_activity_run)
    Button mBtn_start;
    private ActivityUtils mActivityUtils;
    private ImageView[] icons = new ImageView[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        ButterKnife.bind(this);
        mActivityUtils = new ActivityUtils(this);

        if (SpUtils.getBooleanData(this, "is_first_run", true)) {
            initCornerMark();
            initViewPager();
            mBtn_start.setVisibility(View.GONE);
        }else {
            mActivityUtils.startActivity(LogoActivity.class);
            LeadActivity.this.finish();
        }
        mVp_lead.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position==3) {
                    mBtn_start.setVisibility(View.VISIBLE);
                }else {
                    mBtn_start.setVisibility(View.GONE);
                }
                for (int i = 0; i<icons.length ; i++) {
                    icons[i].setBackgroundResource(R.drawable.lead_shape_normal);
                }
                icons[position].setBackgroundResource(R.drawable.lead_shape_select);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initCornerMark() {

        icons[0] = mIv_lead_1;
        icons[1] = mIv_lead_2;
        icons[2] = mIv_lead_3;
        icons[3] = mIv_lead_4;
        icons[0].setBackgroundResource(R.drawable.lead_shape_normal);
    }

    private void initViewPager() {
        final List<ImageView> background = new ArrayList<>();
        ImageView iv1 = new ImageView(this);
        iv1.setBackgroundResource(R.drawable.a);
        ImageView iv2 = new ImageView(this);
        iv2.setBackgroundResource(R.drawable.b);
        ImageView iv3 = new ImageView(this);
        iv3.setBackgroundResource(R.drawable.c);
        ImageView iv4 = new ImageView(this);
        iv4.setBackgroundResource(R.drawable.d);
        background.add(iv1);
        background.add(iv2);
        background.add(iv3);
        background.add(iv4);
        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return background.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(background.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView((View) background.get(position));
                return background.get(position);
            }
        };
        mVp_lead.setAdapter(adapter);
    }

    @OnClick(R.id.start_run_activity_run)
    public void onClick() {

        SpUtils.putBooleanData(LeadActivity.this,"is_first_run",false);
        mActivityUtils.startActivity(LogoActivity.class);
    }
}
