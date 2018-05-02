package com.example.test.MainFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.test.Adapter.ListViewAdapter;
import com.example.test.R;


public class ExcFragment extends Fragment {


    private ListViewAdapter adapter;
    private ListView lv_list;

    public ExcFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exc, container, false);
        initView(view);
        adapter = new ListViewAdapter(null,getActivity());
        lv_list.setAdapter(adapter);
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return view;
    }

    private void initView(View view) {
        lv_list = view.findViewById(R.id.lv_list);
    }
}
