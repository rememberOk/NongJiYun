package com.example.test.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;

public class InfoEditActivity extends AppCompatActivity {

    private ImageView info_edit_return;
    private TextView info_edit_title;
    private EditText info_edit_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_edit);
        initView();

        Intent intent = getIntent();
        int  num = intent.getIntExtra("num",-1);

        switch (num) {
            case 1:
                info_edit_title.setText("用户名");
                info_edit_et.setHint("请输入用户名");
                break;
            case 2:
                info_edit_title.setText("单位名称");
                info_edit_et.setHint("请输入单位名称");
                break;
            case 3:
                info_edit_title.setText("学历");
                info_edit_et.setHint("请输入学历");
                break;
            case 4:
                info_edit_title.setText("邮箱");
                info_edit_et.setHint("请输入邮箱");
                break;
        }

        info_edit_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        info_edit_return = findViewById(R.id.info_edit_return);
        info_edit_title = findViewById(R.id.info_edit_title);
        TextView info_edit_true = findViewById(R.id.info_edit_true);
        info_edit_et = findViewById(R.id.info_edit_et);
    }
}
