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

import com.example.test.MainFragment.MeFragment;
import com.example.test.R;

public class InfoEditActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView info_edit_return;
    private TextView info_edit_title;
    private EditText info_edit_et;
    private TextView info_edit_true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_edit);
        initView();

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        int num = 0;
        if (bundle != null) {
            num = bundle.getInt("num",-1);
        }
        String text = null;
        if (bundle != null) {
            text = bundle.getString("text");
        }

        switch (num) {
            case 1:
                info_edit_title.setText("用户名");
                info_edit_et.setText(text);
//                info_edit_true.setId(R.id.userName);
                break;
            case 2:
                info_edit_title.setText("单位名称");
                info_edit_et.setText(text);
//                info_edit_true.setId(R.id.workAdr);
                break;
            case 3:
                info_edit_title.setText("学历");
                info_edit_et.setText(text);
//                info_edit_true.setId(R.id.edu);
                break;
            case 4:
                info_edit_title.setText("邮箱");
                info_edit_et.setText(text);
//                info_edit_true.setId(R.id.Email);
                break;
        }
    }

    private void initView() {
        info_edit_return = findViewById(R.id.info_edit_return);
        info_edit_return.setOnClickListener(this);
        info_edit_title = findViewById(R.id.info_edit_title);
        info_edit_true = findViewById(R.id.info_edit_true);
        info_edit_true.setOnClickListener(this);
        info_edit_et = findViewById(R.id.info_edit_et);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.info_edit_true) {
            Intent intent = new Intent();
            String info = info_edit_et.getText().toString();
            intent.putExtra("info",info);
            setResult(1,intent);
            finish();
        } else {
            Intent intent = new Intent(getApplicationContext(), InfoMeActivity.class);
           startActivity(intent);
        }
//       if (v.getId() ==  R.id.info_edit_return) {
//           Intent intent = new Intent(getApplicationContext(), InfoMeActivity.class);
//           startActivity(intent);
//       }else if (v.getId() ==  R.id.userName) {
//           Intent intent = new Intent(getApplicationContext(),InfoMeActivity.class);
//           String info = info_edit_et.getText().toString();
//           intent.putExtra("info",info);
//           setResult(1,intent);
//       }else if (v.getId() ==  R.id.workAdr) {
//           Intent intent = new Intent(getApplicationContext(), InfoMeActivity.class);
//           String info = info_edit_et.getText().toString();
//           intent.putExtra("info", info);
//           setResult(2, intent);
//       }else if (v.getId() == R.id.edu) {
//           Intent intent = new Intent(getApplicationContext(),InfoMeActivity.class);
//           String info = info_edit_et.getText().toString();
//           intent.putExtra("info",info);
//           setResult(3,intent);
//       }else if (v.getId() ==  R.id.Email) {
//           Intent intent = new Intent(getApplicationContext(),InfoMeActivity.class);
//           String info = info_edit_et.getText().toString();
//           intent.putExtra("info",info);
//           setResult(4,intent);
//       }
    }
}
