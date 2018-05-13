package com.example.test.MainFragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.Activity.AskAnsActivity;
import com.example.test.Activity.InfoMeActivity;
import com.example.test.Activity.LoginActivity;
import com.example.test.Activity.MeCollectActivity;
import com.example.test.Activity.MeFunctionActivity;
import com.example.test.R;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements View.OnClickListener {

    private TextView me_name;
    private LinearLayout me_true_login;
    private LinearLayout me_no_login;

    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);
        SharedPreferences preferences= getActivity().getSharedPreferences("nongjiyun", MODE_PRIVATE);
        String name = preferences.getString("user_name", "");

        if (TextUtils.isEmpty(name)) {
            me_true_login.setVisibility(View.GONE);
        } else {
            me_no_login.setVisibility(View.GONE);
            me_name.setText(name);
        }
        return view;
    }

    private void initView(View view) {
        CircleImageView me_head_img = view.findViewById(R.id.me_head_img);
        me_name = view.findViewById(R.id.me_name);
        TextView me_work = view.findViewById(R.id.me_work);
        ImageView me_info_img = view.findViewById(R.id.me_info_img);
        me_true_login = view.findViewById(R.id.me_true_login);
        me_no_login = view.findViewById(R.id.me_no_login);
        TextView me_collect = view.findViewById(R.id.me_collect);
        me_collect.setOnClickListener(this);
        TextView me_day_login = view.findViewById(R.id.me_day_login);
        LinearLayout me_sign = view.findViewById(R.id.me_sign);
        me_sign.setOnClickListener(this);
        LinearLayout me_setting = view.findViewById(R.id.me_setting);
        me_setting.setOnClickListener(this);
        LinearLayout me_ask = view.findViewById(R.id.me_ask);
        me_ask.setOnClickListener(this);
        me_no_login.setOnClickListener(this);
        me_true_login.setOnClickListener(this);
        LinearLayout me_exc = view.findViewById(R.id.me_exc);
        me_exc.setOnClickListener(this);
        LinearLayout me_think = view.findViewById(R.id.me_think);
        me_think.setOnClickListener(this);
        LinearLayout me_share = view.findViewById(R.id.me_share);
        me_share.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(),MeFunctionActivity.class);
        switch (view.getId()) {
            case R.id.me_no_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.me_true_login:
                startActivity(new Intent(getActivity(), InfoMeActivity.class));
                break;
            case R.id.me_collect:
                startActivity(new Intent(getActivity(), MeCollectActivity.class));
                break;
            case R.id.me_ask:
                startActivity(new Intent(getActivity(), AskAnsActivity.class));
                break;
            case R.id.me_exc:
                intent.putExtra("num",1);
                startActivity(intent);
                break;
            case R.id.me_think:
                intent.putExtra("num",2);
                startActivity(intent);
                break;
            case R.id.me_setting:
                intent.putExtra("num",3);
                startActivity(intent);
                break;
            case R.id.me_share:
                intent.putExtra("num",4);
                startActivity(intent);
                break;
        }
    }
}
