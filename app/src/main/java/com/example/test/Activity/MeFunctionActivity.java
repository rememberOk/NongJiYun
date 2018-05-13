package com.example.test.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.MeFragment.FucExcFragment;
import com.example.test.MeFragment.FucSetFragment;
import com.example.test.MeFragment.FucShareFragment;
import com.example.test.MeFragment.FucThinkFragment;
import com.example.test.R;

public class MeFunctionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView top_title;
    private ImageView iv_return;
    private FrameLayout fl_function;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_function);
        initView();

        Intent intent = getIntent();
        int num = intent.getIntExtra("num", -1);
        switch (num) {
            case 1:
                top_title.setText("我的交流");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_function,
                        new FucExcFragment()).commit();
                break;
            case 2:
                top_title.setText("意见反馈");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_function,
                        new FucThinkFragment()).commit();
                break;
            case 3:
                top_title.setText("系统设置");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_function,
                        new FucSetFragment()).commit();
                break;
            case 4:
                top_title.setText("分享农技耘");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_function,
                        new FucShareFragment()).commit();
                break;
        }
    }

    private void initView() {
        top_title = findViewById(R.id.top_title);
        FrameLayout fl_function = findViewById(R.id.fl_function);
        iv_return = findViewById(R.id.iv_return);
        iv_return.setOnClickListener(this);
        fl_function = findViewById(R.id.fl_function);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
