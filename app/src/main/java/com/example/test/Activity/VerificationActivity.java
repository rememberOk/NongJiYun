package com.example.test.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.R;
import com.zhy.http.okhttp.OkHttpUtils;

import static com.example.test.Constant.Url.SERVER_BASE_URL;

public class VerificationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_phone;
    private Button bt_post;
    private EditText et_ver;
    private Button tb_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        initView();

    }

    private void initView() {
        et_phone = findViewById(R.id.et_phone);
        bt_post = findViewById(R.id.bt_post);
        et_ver = findViewById(R.id.et_ver);
        tb_next = findViewById(R.id.tb_next);

        bt_post.setOnClickListener(this);
        tb_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_post:

                break;
            case R.id.tb_next:

                break;
        }
    }

    private void submit() {
        // validate
        String phone = et_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String ver = et_ver.getText().toString().trim();
        if (TextUtils.isEmpty(ver)) {
            Toast.makeText(this, "ver不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
//    public void getVer() {
//
//        OkHttpUtils
//                .postString()
//                .url(SERVER_BASE_URL+"insert-user")
//                .content()
//    }
}
