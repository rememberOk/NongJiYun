package com.example.test.MainFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test.Activity.LoginActivity;
import com.example.test.R;
import com.example.test.entity.User;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

    private User user;
    private CircleImageView me_head_img;
    private TextView me_name;
    private TextView me_work;
    private ImageView me_info_img;
    private LinearLayout me_true_login;
    private LinearLayout me_no_login;
    private LinearLayout me_collect;
    private LinearLayout me_integral;
    private LinearLayout me_shop;
    private TextView me_day_login;
    private LinearLayout me_sign;
    private LinearLayout me_setting;
    private LinearLayout me_ask;
    private LinearLayout me_answer;
    private LinearLayout me_login;

    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);

        user = new User();
        if (TextUtils.isEmpty(user.getUserName())) {
            me_true_login.setVisibility(View.GONE);
        } else {
            me_no_login.setVisibility(View.GONE);
        }
//        未登录
        me_no_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Objects.requireNonNull(getActivity()),LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initView(View view) {
        me_head_img = view.findViewById(R.id.me_head_img);
        me_name = view.findViewById(R.id.me_name);
        me_work = view.findViewById(R.id.me_work);
        me_info_img = view.findViewById(R.id.me_info_img);
        me_true_login = view.findViewById(R.id.me_true_login);
        me_no_login = view.findViewById(R.id.me_no_login);
        me_collect = view.findViewById(R.id.me_collect);
        me_integral = view.findViewById(R.id.me_integral);
        me_shop = view.findViewById(R.id.me_shop);
        me_day_login = view.findViewById(R.id.me_day_login);
        me_sign = view.findViewById(R.id.me_sign);
        me_setting = view.findViewById(R.id.me_setting);
        me_ask = view.findViewById(R.id.me_ask);
        me_answer = view.findViewById(R.id.me_answer);
        me_login = view.findViewById(R.id.me_login);
    }
}
