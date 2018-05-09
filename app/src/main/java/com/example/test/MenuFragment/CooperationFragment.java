package com.example.test.MenuFragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.Adapter.ViewPagerAdapter;
import com.example.test.R;
import com.example.test.fragment.BrandFragment;
import com.example.test.fragment.CooFragment;
import com.example.test.fragment.LibraryFragment;
import com.example.test.fragment.PolicyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CooperationFragment extends Fragment {


    private TabLayout tl_brand;
    private ViewPager vp_brand;
    private ViewPagerAdapter pagerAdapter;

    public CooperationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cooperation, container, false);
        initView(view);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LibraryFragment());
        fragments.add(new CooFragment());
        fragments.add(new PolicyFragment());
        fragments.add(new BrandFragment());

        List<String> titles = new ArrayList<>();
        titles.add("名录库");
        titles.add("合作风采");
        titles.add("政策法规");
        titles.add("苏合品牌");

        pagerAdapter = new ViewPagerAdapter(getFragmentManager(),fragments,titles);
        vp_brand.setAdapter(pagerAdapter);
        tl_brand.setupWithViewPager(vp_brand);

        return view;
    }

    private void initView(View view) {
        tl_brand = view.findViewById(R.id.tl_brand);
        vp_brand = view.findViewById(R.id.vp_brand);
    }
}
