package com.example.test.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText login_phone;
    private EditText login_psw;
    private Button login_submit;
    private TextView login_forget;
    private Button login_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        login_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),LoginForgetActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        login_phone = findViewById(R.id.login_phone);
        login_psw = findViewById(R.id.login_psw);
        login_submit = findViewById(R.id.login_submit);
        login_forget = findViewById(R.id.login_forget);
        login_register = findViewById(R.id.login_register);
        login_submit.setOnClickListener(this);
        login_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_submit:

                break;
            case R.id.login_register:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void submit() {
        // validate
        String phone = login_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String psw = login_psw.getText().toString().trim();
        if (TextUtils.isEmpty(psw)) {
            Toast.makeText(this, "psw不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
