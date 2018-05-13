package com.example.test.MenuFragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.Adapter.ViewPagerAdapter;
import com.example.test.BrandFrgment.DynamicFragment;
import com.example.test.BrandFrgment.FertilizerFragment;
import com.example.test.BrandFrgment.PesticideFragment;
import com.example.test.BrandFrgment.SeedFragment;
import com.example.test.BrandFrgment.SpecialFragment;
import com.example.test.R;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrandAgriculturalFragment extends Fragment {


    private TabLayout tl_brand;
    private ViewPager vp_brand;
    private ViewPagerAdapter adapter;

    public BrandAgriculturalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_brand_agricultural, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DynamicFragment());
        fragments.add(new SpecialFragment());
        fragments.add(new PesticideFragment());
        fragments.add(new FertilizerFragment());
        fragments.add(new SeedFragment());

        List<String> titles = new ArrayList<>();
        titles.add("动态");
        titles.add("专题");
        titles.add("农药");
        titles.add("肥料");
        titles.add("种子");

        adapter = new ViewPagerAdapter(getFragmentManager(),fragments,titles);
        vp_brand.setAdapter(adapter);
        tl_brand.setupWithViewPager(vp_brand);
    }

    private void initView(View view) {
        tl_brand = view.findViewById(R.id.tl_brand);
        vp_brand = view.findViewById(R.id.vp_brand);
    }
}
