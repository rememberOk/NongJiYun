package com.example.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.test.Adapter.ListViewPriceAdapter;
import com.example.test.R;
import com.example.test.entity.RedListView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketPriceFragment extends Fragment {


    private ListViewPriceAdapter redAdapter;
    private List<RedListView> redListViews;
    private ListView lv_list_price;

    public MarketPriceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_market_price, container, false);
        initView(view);
        redAdapter = new ListViewPriceAdapter(null, getActivity());
        lv_list_price.setAdapter(redAdapter);

        return view;
    }

    private void initView(View view) {
        lv_list_price = view.findViewById(R.id.lv_list_price);
    }
}
