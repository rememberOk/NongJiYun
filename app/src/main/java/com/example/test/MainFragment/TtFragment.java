package com.example.test.MainFragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.Adapter.VerticalBannerAdapter;
import com.example.test.R;
import com.example.test.entity.VerticalBanner;
import com.taobao.library.VerticalBannerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TtFragment extends Fragment {


    private VerticalBannerView banner;
    private VerticalBannerAdapter adapter;

    public TtFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tt, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<VerticalBanner> data = new ArrayList<>();
        data.add(new VerticalBanner("李益凡小垃圾"));
        data.add(new VerticalBanner("李益凡小垃圾"));
        data.add(new VerticalBanner("李益凡小垃圾"));
        data.add(new VerticalBanner("李益凡小垃圾"));
        data.add(new VerticalBanner("李益凡小垃圾"));
        adapter = new VerticalBannerAdapter(data);
        banner.setAdapter(adapter);
        banner.start();
    }

    private void initView(View view) {
        banner = view.findViewById(R.id.banner);
    }
}
