package com.example.test.fragment;


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
public class PolicyFragment extends Fragment {

    private ListViewDynamicAdapter dynamicAdapter;
    private ListView lv_list;

    public PolicyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_policy, container, false);
        initView(view);
        dynamicAdapter = new ListViewDynamicAdapter(getActivity());
        lv_list.setAdapter(dynamicAdapter);
        return view;
    }

    private void initView(View view) {
        lv_list = view.findViewById(R.id.lv_list);
    }
}
