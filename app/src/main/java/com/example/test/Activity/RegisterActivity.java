package com.example.test.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView type_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();


    }

    private void initView() {
        type_info =  findViewById(R.id.register_type_info);
        LinearLayout register_type = findViewById(R.id.register_type);
        register_type.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register_type:
                startActivityForResult(new Intent(RegisterActivity.this,
                        RegisterTypeActivity.class), 1);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 4) {
            String type =data.getStringExtra("type");
            type_info.setText(type);
        }
    }
}
