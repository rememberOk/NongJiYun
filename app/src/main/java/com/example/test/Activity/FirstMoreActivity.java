package com.example.test.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.fragment.HeadFragment;
import com.example.test.fragment.MainDynamicFragment;
import com.example.test.fragment.VideoFragment;

public class FirstMoreActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView menu_back_first;
    private TextView tv_title;
    private FrameLayout fl_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_more);
        initView();
        Intent intent = getIntent();
        int num= intent.getIntExtra("num",-1);

        switch (num) {
            case 1:
                tv_title.setText("头条");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_more,
                        new HeadFragment()).commit();
                break;
            case 2:
                tv_title.setText("动态");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_more,
                        new MainDynamicFragment()).commit();
                break;
            case 3:
                tv_title.setText("农业视频");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_more,
                        new VideoFragment()).commit();
                break;
        }
    }

    private void initView() {
        menu_back_first = findViewById(R.id.menu_back_first);
        menu_back_first.setOnClickListener(this);
        tv_title = findViewById(R.id.tv_title);
        fl_more = findViewById(R.id.fl_more);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
