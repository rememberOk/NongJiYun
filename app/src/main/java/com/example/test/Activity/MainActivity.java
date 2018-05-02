package com.example.test.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import com.example.test.MainFragment.ExcFragment;
import com.example.test.MainFragment.FirstFragment;
import com.example.test.MainFragment.MeFragment;
import com.example.test.MainFragment.QueFragment;
import com.example.test.MainFragment.TtFragment;
import com.example.test.R;


public class MainActivity extends AppCompatActivity {

    private RadioGroup rg_bt_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        getSupportFragmentManager().beginTransaction().replace(R.id.ft_exchange,
                new FirstFragment()).commit();

        rg_bt_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_first:
                        getSupportFragmentManager().beginTransaction().replace(R.id.ft_exchange,
                                new FirstFragment()).commit();
                        break;
                    case R.id.rb_tt:
                        getSupportFragmentManager().beginTransaction().replace(R.id.ft_exchange,
                                new TtFragment()).commit();
                        break;
                    case R.id.rg_qes:
                        getSupportFragmentManager().beginTransaction().replace(R.id.ft_exchange,
                                new QueFragment()).commit();
                        break;
                    case R.id.rg_exc:
                        getSupportFragmentManager().beginTransaction().replace(R.id.ft_exchange,
                                new ExcFragment()).commit();
                        break;
                    case R.id.rg_me:
                        getSupportFragmentManager().beginTransaction().replace(R.id.ft_exchange,
                                new MeFragment()).commit();
                        break;
                }
            }
        });
    }

    private void initView() {
            rg_bt_group = findViewById(R.id.rg_bt_group);
        }
}
