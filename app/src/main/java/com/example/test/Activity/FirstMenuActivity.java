package com.example.test.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.MainFragment.FirstFragment;
import com.example.test.MenuFragment.AgriculturalPolicyFragment;
import com.example.test.MenuFragment.BrandAgriculturalFragment;
import com.example.test.MenuFragment.CooperationFragment;
import com.example.test.MenuFragment.ExpertFragment;
import com.example.test.MenuFragment.FarmingFragment;
import com.example.test.MenuFragment.MarketFragment;
import com.example.test.MenuFragment.ScienceFragment;
import com.example.test.MenuFragment.SpecialScienceFragment;
import com.example.test.R;

public class FirstMenuActivity extends AppCompatActivity {

    private TextView tv_content_title;
    private ImageView menu_back_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_fragment);
        initView();
        Intent intent = getIntent();
        int model = intent.getIntExtra("model", -1);
        switch (model) {
            case 1:
                tv_content_title.setText("品牌农资");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu_content,
                        new BrandAgriculturalFragment()).commit();
                break;
            case 2:
                tv_content_title.setText("应时农事");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu_content,
                        new FarmingFragment()).commit();
                break;
            case 3:
                tv_content_title.setText("市场行情");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu_content,
                        new MarketFragment()).commit();
                break;
            case 4:
                tv_content_title.setText("农业科技");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu_content,
                        new ScienceFragment()).commit();
                break;
            case 5:
                tv_content_title.setText("农业专家");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu_content,
                        new ExpertFragment()).commit();
                break;
            case 6:
                tv_content_title.setText("农业政策");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu_content,
                        new AgriculturalPolicyFragment()).commit();
                break;
            case 7:
                tv_content_title.setText("科技专项");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu_content,
                        new SpecialScienceFragment()).commit();
                break;
            case 8:
                tv_content_title.setText("专业合作");
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu_content,
                        new CooperationFragment()).commit();
                break;
        }

        menu_back_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initView() {
        tv_content_title = findViewById(R.id.tv_content_title);
        menu_back_first = findViewById(R.id.menu_back_first);
    }
}
