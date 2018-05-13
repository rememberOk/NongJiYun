package com.example.test.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.test.Adapter.ViewPagerAdapter;
import com.example.test.R;
import com.example.test.fragment.SelfFragment;
import com.example.test.fragment.SystemFragment;

import java.util.ArrayList;
import java.util.List;

public class NoticeActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tl_notice;
    private ViewPager vp_notice;
    private ImageView iv_return_notice;
    private FrameLayout fl_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        initView();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new SystemFragment());
        fragments.add(new SelfFragment());

        List<String> titles = new ArrayList<>();
        titles.add("系统通知");
        titles.add("个人通知");

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
        vp_notice.setAdapter(pagerAdapter);
        tl_notice.setupWithViewPager(vp_notice);

    }

    private void initView() {
        tl_notice = findViewById(R.id.tl_notice);
        vp_notice = findViewById(R.id.vp_notice);
        FrameLayout fl_notice = findViewById(R.id.fl_notice);
        iv_return_notice = findViewById(R.id.iv_return_notice);
        iv_return_notice.setOnClickListener(this);
        fl_notice = findViewById(R.id.fl_notice);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
