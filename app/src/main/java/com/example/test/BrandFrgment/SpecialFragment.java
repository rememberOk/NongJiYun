package com.example.test.BrandFrgment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.test.Adapter.ListViewDynamicAdapter;
import com.example.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialFragment extends Fragment {

    private ListViewDynamicAdapter dynamicAdapter;
    private ListView lv_special;

    public SpecialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_special, container, false);
        initView(view);
        dynamicAdapter = new ListViewDynamicAdapter(getActivity());
        lv_special.setAdapter(dynamicAdapter);
        return view;
    }

    private void initView(View view) {
        lv_special = view.findViewById(R.id.lv_special);
    }
}
