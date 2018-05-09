package com.example.test.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.test.R;

public class RegisterTypeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView type_back;
    private RadioButton type_manager;
    private RadioButton type_expert;
    private RadioButton type_science;
    private RadioButton type_man;
    private RadioButton type_cooperation;
    private RadioButton type_farm;
    private RadioButton type_enterprise;
    private RadioButton type_big;
    private RadioButton type_household;
    private RadioButton type_other;
    private RadioGroup type_rg;
    private String selectedType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_type);
        initView();

        type_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.type_manager:
                        selectedType = type_manager.getText().toString();
                        break;
                    case R.id.type_expert:
                        selectedType = type_expert.getText().toString();
                        break;
                    case R.id.type_science:
                        selectedType = type_science.getText().toString();
                        break;
                    case R.id.type_man:
                        selectedType = type_man.getText().toString();
                        break;
                    case R.id.type_farm:
                        selectedType = type_farm.getText().toString();
                        break;
                    case R.id.type_cooperation:
                        selectedType = type_cooperation.getText().toString();
                        break;
                    case R.id.type_enterprise:
                        selectedType = type_enterprise.getText().toString();
                        break;
                    case R.id.type_big:
                        selectedType = type_big.getText().toString();
                        break;
                    case R.id.type_household:
                        selectedType = type_household.getText().toString();
                        break;
                    case R.id.type_other:
                        selectedType = type_other.getText().toString();
                        break;
                }
            }
        });
    }

    private void initView() {
        type_back = findViewById(R.id.type_back);
        type_manager = findViewById(R.id.type_manager);
        type_expert = findViewById(R.id.type_expert);
        type_science = findViewById(R.id.type_science);
        type_man = findViewById(R.id.type_man);
        type_cooperation = findViewById(R.id.type_cooperation);
        type_farm = findViewById(R.id.type_farm);
        type_enterprise = findViewById(R.id.type_enterprise);
        type_big = findViewById(R.id.type_big);
        type_household = findViewById(R.id.type_household);
        type_other = findViewById(R.id.type_other);
        type_rg = findViewById(R.id.type_rg);
        type_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.type_back) {
            if (TextUtils.isEmpty(selectedType)) {
                Toast.makeText(this,"请选择其中一项",Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra("type", selectedType);
                setResult(4, intent);
                finish();
            }
        }
    }
}
