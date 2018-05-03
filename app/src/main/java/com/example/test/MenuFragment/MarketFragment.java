package com.example.test.MenuFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.test.MainFragment.FirstFragment;
import com.example.test.R;
import com.example.test.fragment.MarketFocusFragment;
import com.example.test.fragment.MarketPriceFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketFragment extends Fragment {


    private RadioButton list_me_img;
    private RadioButton rb_price;
    private RadioButton rb_focus;
    private RadioGroup rg_group_market;
    private FrameLayout ft_market;

    public MarketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_market, container, false);
        initView(view);

        getFragmentManager().beginTransaction().replace(R.id.ft_market,
                new MarketPriceFragment()).commit();

        rg_group_market.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_price) {
                    getFragmentManager().beginTransaction().replace(R.id.ft_market,
                            new MarketPriceFragment()).commit();
                }else if (i == R.id.rb_focus) {
                    getFragmentManager().beginTransaction().replace(R.id.ft_market,
                            new MarketFocusFragment()).commit();
                }
            }
        });

        return view;
    }

    private void initView(View view) {
        list_me_img = view.findViewById(R.id.list_me_img);
        rb_price = view.findViewById(R.id.rb_price);
        rb_focus = view.findViewById(R.id.rb_focus);
        rg_group_market = view.findViewById(R.id.rg_group_market);
        ft_market = view.findViewById(R.id.ft_market);
    }
}
