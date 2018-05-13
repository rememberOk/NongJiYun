package com.example.test.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.entity.User;
import com.example.test.entity.Ver;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.MediaType;

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
                getVerCode();
                break;
            case R.id.tb_next:
                submit();
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
        String  verCode = et_ver.getText().toString();
        Log.i("code", String.valueOf(verCode));
        SharedPreferences preferences = getSharedPreferences("ver", MODE_PRIVATE);
        String  code = preferences.getString("code", "");
        Log.i("code2", String.valueOf(code));
        final String phoneNum = preferences.getString("phone", "");
        if (code.equals(verCode)) {
            Intent intent = new Intent(getApplication(),RegisterActivity.class);
            intent.putExtra("phone", phoneNum);
            startActivity(intent);
        } else {
            Toast.makeText(this,"验证码输入不正确",Toast.LENGTH_LONG).show();
        }
    }

    public void getVerCode() {
        String account = et_phone.getText().toString();
        OkHttpUtils
                .postString()
                .url(SERVER_BASE_URL + "ifregister")
                .content("{\"user_account\":\"" + account + "\"}")
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {

                    }

                    @Override
                    public void onResponse(String s, int i) {
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            int code = jsonObject.getInt("code");
                            switch (code) {
                                case 1001:
                                    Toast.makeText(VerificationActivity.this, "验证码发送成功", Toast.LENGTH_LONG).show();
                                    JSONObject object = jsonObject.getJSONObject("data");
                                    Ver ver = new Gson().fromJson(object.toString(), Ver.class);
                                    SharedPreferences.Editor editor = getSharedPreferences("ver", MODE_PRIVATE).edit();
                                    editor.putString("code", ver.getCode());
                                    Log.i("code",ver.getCode());
                                    editor.putString("phone", ver.getPhone());
                                    editor.apply();
//                                    Log.i("code",ver.getCode());
                                    break;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
