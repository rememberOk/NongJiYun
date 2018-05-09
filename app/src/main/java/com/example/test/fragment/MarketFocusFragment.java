package com.example.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.test.Adapter.ListViewPriceAdapter;
import com.example.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketFocusFragment extends Fragment {

    private ListViewPriceAdapter priceAdapter;
    private ListView lv_list_focus;

    public MarketFocusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_market_focus, container, false);
        initView(view);

        priceAdapter = new ListViewPriceAdapter(null,getActivity());
        lv_list_focus.setAdapter(priceAdapter);
        return view;
    }

    private void initView(View view) {
        lv_list_focus = (ListView) view.findViewById(R.id.lv_list_focus);
    }
}
