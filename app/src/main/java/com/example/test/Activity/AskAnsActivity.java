package com.example.test.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.Adapter.ViewPagerAdapter;
import com.example.test.MeFragment.AllAnsFragment;
import com.example.test.MeFragment.AllAskFragment;
import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class AskAnsActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tl_me;
    private ViewPager vp_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_ans);
        initView();


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new AllAskFragment());
        fragments.add(new AllAnsFragment());

        List<String> titles = new ArrayList<>();
        titles.add("我的提问");
        titles.add("我的回答");

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
        vp_me.setAdapter(pagerAdapter);
        tl_me.setupWithViewPager(vp_me);
    }

    private void initView() {
        tl_me = findViewById(R.id.tl_me);
        vp_me = findViewById(R.id.vp_me);
        ImageView iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
