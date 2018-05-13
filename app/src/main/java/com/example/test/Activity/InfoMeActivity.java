package com.example.test.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.test.MainFragment.MeFragment;
import com.example.test.R;

public class InfoMeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView username;
    private TextView work;
    private TextView identity;
    private TextView education;
    private TextView address;
    private TextView sex;
    private TextView phone;
    private TextView email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_me);
        initView();
        updateText();
    }

    private void initView() {
        ImageView info_me_return = findViewById(R.id.info_me_return);
        LinearLayout info_img_head = findViewById(R.id.info_img_head);
        LinearLayout info_username = findViewById(R.id.info_username);
        LinearLayout info_work = findViewById(R.id.info_work);
        LinearLayout info_identity = findViewById(R.id.info_identity);
        LinearLayout info_Education = findViewById(R.id.info_Education);
        LinearLayout info_adress = findViewById(R.id.info_adress);
        LinearLayout info_sex = findViewById(R.id.info_sex);
        LinearLayout info_email = findViewById(R.id.info_email);
        info_me_return.setOnClickListener(this);
        info_img_head.setOnClickListener(this);
        info_username.setOnClickListener(this);
        info_work.setOnClickListener(this);
        info_identity.setOnClickListener(this);
        info_Education.setOnClickListener(this);
        info_adress.setOnClickListener(this);
        info_sex.setOnClickListener(this);
        info_email.setOnClickListener(this);
        username = findViewById(R.id.username);
        username.setOnClickListener(this);
        work = findViewById(R.id.work);
        work.setOnClickListener(this);
        identity = findViewById(R.id.identity);
        identity.setOnClickListener(this);
        education = findViewById(R.id.education);
        education.setOnClickListener(this);
        address = findViewById(R.id.address);
        address.setOnClickListener(this);
        sex = findViewById(R.id.sex);
        sex.setOnClickListener(this);
        phone = findViewById(R.id.phone);
        phone.setOnClickListener(this);
        email = findViewById(R.id.email);
        email.setOnClickListener(this);
        RadioButton rb_user = findViewById(R.id.rb_user);
        rb_user.setOnClickListener(this);
        RadioButton rb_work = findViewById(R.id.rb_work);
        rb_work.setOnClickListener(this);
        RadioButton rb_identity = findViewById(R.id.rb_identity);
        rb_identity.setOnClickListener(this);
        RadioButton rb_education = findViewById(R.id.rb_education);
        rb_education.setOnClickListener(this);
        RadioButton rb_adr = findViewById(R.id.rb_adr);
        rb_adr.setOnClickListener(this);
        RadioButton rb_sex = findViewById(R.id.rb_sex);
        rb_sex.setOnClickListener(this);
        RadioButton rb_phone = findViewById(R.id.rb_phone);
        rb_phone.setOnClickListener(this);
        RadioButton rb_email = findViewById(R.id.rb_email);
        rb_email.setOnClickListener(this);
    }

    @SuppressLint("CommitTransaction")
    @Override
    public void onClick(View view) {
        int v = view.getId();
        if (v == R.id.info_me_return) {
            finish();
        } else if (v == R.id.rb_user || v == R.id.info_username) {
            Intent intent = new Intent(getApplicationContext(), InfoEditActivity.class);
            String text = username.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putInt("num",1);
            bundle.putString("text",text);
            intent.putExtras(bundle);
            startActivityForResult(intent,1);
        } else if (v == R.id.info_work || v == R.id.rb_work ) {
            Intent intent = new Intent(getApplicationContext(), InfoEditActivity.class);
            String text = work.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putInt("num",2);
            bundle.putString("text",text);
            intent.putExtras(bundle);
            startActivityForResult(intent,2);
        } else if (v == R.id.rb_education || v == R.id.info_Education ) {
            Intent intent = new Intent(getApplicationContext(), InfoEditActivity.class);
            String text = education.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putInt("num",3);
            bundle.putString("text",text);
            intent.putExtras(bundle);
            startActivityForResult(intent,3);
        } else if (v == R.id.info_email || v == R.id.rb_email ) {
            Intent intent = new Intent(getApplicationContext(), InfoEditActivity.class);
            String text = email.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putInt("num",4);
            bundle.putString("text",text);
            intent.putExtras(bundle);
            startActivityForResult(intent,4);
        }
    }

    public void updateText() {
        SharedPreferences preferences = getSharedPreferences("user", MODE_PRIVATE);
        String userName = preferences.getString("username", "嗯哼");
        String workAdr = preferences.getString("work", "南京市栖霞区仙林大道");
        String identitySelf = preferences.getString("identity", "村民");
        String educationSelf = preferences.getString("education", "你好哇");
        String addressSelf = preferences.getString("adress", "南京市");
        String sexSelf = preferences.getString("sex", "男");
        String phoneNum = preferences.getString("phone", "11111111111");
        String emailNum = preferences.getString("email", "2357496648@qq.com");
        username.setText(userName);
        work.setText(workAdr);
        identity.setText(identitySelf);
        education.setText(educationSelf);
        address.setText(addressSelf);
        sex.setText(sexSelf);
        phone.setText(phoneNum);
        email.setText(emailNum);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String info = data.getStringExtra("info");
        if (requestCode == 1 && resultCode == 1) {
            username.setText(info);
        } else if (requestCode == 2 && resultCode== 2) {
            work.setText(info);
        } else if (requestCode == 3 && resultCode== 3) {
            education.setText(info);
        } else if (requestCode == 4 & resultCode== 4) {
            email.setText(info);
        }
    }
}
