package com.example.test.Activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.Adapter.ViewPagerAdapter;
import com.example.test.MeFragment.AksFragment;
import com.example.test.MeFragment.InformationFragment;
import com.example.test.MeFragment.MeExcFragment;
import com.example.test.R;
import com.example.test.fragment.VideoFragment;
import java.util.ArrayList;
import java.util.List;

public class MeCollectActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tl_collect;
    private ViewPager vp_collect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_collect);
        initView();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new AksFragment());
        fragments.add(new MeExcFragment());
        fragments.add(new InformationFragment());
        fragments.add(new VideoFragment());

        List<String> titles = new ArrayList<>();
        titles.add("问答");
        titles.add("交流");
        titles.add("资讯");
        titles.add("视频");

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments,titles);
        vp_collect.setAdapter(pagerAdapter);
        tl_collect.setupWithViewPager(vp_collect);
    }

    private void initView() {
        ImageView menu_back_first = findViewById(R.id.menu_back_first);
        menu_back_first.setOnClickListener(this);
        TextView tv_title = findViewById(R.id.tv_title);
        tl_collect = findViewById(R.id.tl_collect);
        vp_collect = findViewById(R.id.vp_collect);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
