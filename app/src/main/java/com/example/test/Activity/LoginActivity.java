package com.example.test.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.test.R;
import com.example.test.entity.User;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.MediaType;

import static com.example.test.Constant.Url.SERVER_BASE_URL;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText login_phone;
    private EditText login_psw;
    private Button login_submit;
    private TextView login_forget;
    private Button login_register;
    private ImageView login_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        SharedPreferences preferences= getSharedPreferences("nongjiyun", MODE_PRIVATE);

    }

    private void initView() {
        login_phone = findViewById(R.id.login_phone);
        login_psw = findViewById(R.id.login_psw);
        login_submit = findViewById(R.id.login_submit);
        login_forget = findViewById(R.id.login_forget);
        login_register = findViewById(R.id.login_register);
        login_back = findViewById(R.id.login_back);
        login_forget.setOnClickListener(this);
        login_back.setOnClickListener(this);
        login_submit.setOnClickListener(this);
        login_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_submit:
                submit();
                finish();
                break;
            case R.id.login_register:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), VerificationActivity.class);
                startActivity(intent);
                break;
            case R.id.login_forget:
                Intent intentF = new Intent();
                intentF.setClass(getApplicationContext(), LoginForgetActivity.class);
                startActivity(intentF);
            case R.id.login_back:
                finish();
        }
    }

    private void submit() {
        // validate
        String phone = login_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String psw = login_psw.getText().toString().trim();
        if (TextUtils.isEmpty(psw)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something
        OkHttpUtils
                .postString()
                .url(SERVER_BASE_URL+"login")
                .content("{\"user_account\":\"" + phone + "\",\"user_password\":\"" + psw + "\"}")
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        Toast.makeText(LoginActivity.this, "操作不合法！", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(String s, int i) {
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            int code = jsonObject.getInt("code");
                            switch (code) {
                                case 1001:
                                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                    JSONObject object = jsonObject.getJSONObject("data");
                                    User user = new Gson().fromJson(object.toString(),User.class);
                                    SharedPreferences.Editor editor = getSharedPreferences("nongjiyun", MODE_PRIVATE).edit();
                                    editor.putString("user_name",user.getUser_name());
                                    editor.putString("user_account",user.getUser_account());
                                    editor.putString("user_password",user.getUser_password());
                                    editor.putString("unit_name",user.getUnit_name());
                                    editor.putInt("sex",user.getSex());
                                    editor.putString("education",user.getEducation());
                                    editor.putString("email",user.getEmail());
                                    editor.putInt("identity_id",user.getIdentity_id());
                                    editor.putBoolean("isLogin",true);
                                    editor.apply();
                                    break;
                                case 1003:
                                    Toast.makeText(LoginActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
//    public void getUser() {
//        int num = 2;
//        OkHttpUtils
//                .postString()
//                .url(SERVER_BASE_URL+"userinfo")
//                .content("{\"user_id\":\""+num+"\"}")
//                .mediaType(MediaType.parse("application/json; charset=utf-8"))
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int i) {
//                    }
//                    @Override
//                    public void onResponse(String s, int i) {
//                        try {
//                            JSONObject object = new JSONObject(s);
//                            JSONObject jsonObject = object.getJSONObject("data");
//                            User user = new Gson().fromJson(jsonObject.toString(),User.class);
//                            Log.i("user",user.toString());
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//    }
}
