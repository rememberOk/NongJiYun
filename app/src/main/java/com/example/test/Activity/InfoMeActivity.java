package com.example.test.Activity;

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
    private TextView adress;
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
        LinearLayout me_login = findViewById(R.id.me_login);
        info_me_return.setOnClickListener(this);
        info_img_head.setOnClickListener(this);
        info_username.setOnClickListener(this);
        info_work.setOnClickListener(this);
        info_identity.setOnClickListener(this);
        info_Education.setOnClickListener(this);
        info_adress.setOnClickListener(this);
        info_sex.setOnClickListener(this);
        info_email.setOnClickListener(this);
        me_login.setOnClickListener(this);
        username = findViewById(R.id.username);
        username.setOnClickListener(this);
        work = findViewById(R.id.work);
        work.setOnClickListener(this);
        identity = findViewById(R.id.identity);
        identity.setOnClickListener(this);
        education = findViewById(R.id.education);
        education.setOnClickListener(this);
        adress = findViewById(R.id.adress);
        adress.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_me_return:
                finish();
            case R.id.info_edit_return:
                finish();
                break;
            case R.id.rb_user:
                Intent intentU = new Intent(getApplicationContext(), InfoEditActivity.class);
                intentU.putExtra("num", 1);
                startActivity(intentU);
                break;
            case R.id.info_username:
                Intent intent = new Intent(getApplicationContext(), InfoEditActivity.class);
                intent.putExtra("num", 1);
                startActivity(intent);
                break;
            case R.id.info_work:
                Intent intentW = new Intent(getApplicationContext(), InfoEditActivity.class);
                intentW.putExtra("num", 2);
                startActivity(intentW);
                break;
            case R.id.rb_work:
                Intent intentK = new Intent(getApplicationContext(), InfoEditActivity.class);
                intentK.putExtra("num", 2);
                startActivity(intentK);
                break;
            case R.id.info_Education:
                Intent intentE = new Intent(getApplicationContext(), InfoEditActivity.class);
                intentE.putExtra("num", 3);
                startActivity(intentE);
                break;
            case R.id.rb_education:
                Intent intentD = new Intent(getApplicationContext(), InfoEditActivity.class);
                intentD.putExtra("num", 3);
                startActivity(intentD);
                break;
            case R.id.info_email:
                Intent intentM = new Intent(getApplicationContext(), InfoEditActivity.class);
                intentM.putExtra("num", 4);
                startActivity(intentM);
                break;
            case R.id.rb_email:
                Intent intentL = new Intent(getApplicationContext(), InfoEditActivity.class);
                intentL.putExtra("num", 4);
                startActivity(intentL);
                break;
        }

    }

    public void updateText() {
        SharedPreferences preferences = getSharedPreferences("user", MODE_PRIVATE);
        String userName = preferences.getString("username", "嗯哼");
        String workAdr = preferences.getString("work", "南京市栖霞区仙林大道");
        String identitySelf = preferences.getString("identity", "村民");
        String educationSelf = preferences.getString("education", "你好哇");
        String adressSelf = preferences.getString("adress", "南京市");
        String sexSelf = preferences.getString("sex", "男");
        String phoneNum = preferences.getString("phone", "11111111111");
        String emailNum = preferences.getString("email", "2357496648@qq.com");
        username.setText(userName);
        work.setText(workAdr);
        identity.setText(identitySelf);
        education.setText(educationSelf);
        adress.setText(adressSelf);
        sex.setText(sexSelf);
        phone.setText(phoneNum);
        email.setText(emailNum);
    }
}
