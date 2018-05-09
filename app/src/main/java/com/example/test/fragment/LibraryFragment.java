package com.example.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.test.Adapter.ListViewDynamicAdapter;
import com.example.test.Adapter.ListViewFarmingAdapter;
import com.example.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LibraryFragment extends Fragment {


    private ListView lv_list;
    private ListViewDynamicAdapter adapter;
    public LibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        initView(view);

        adapter = new ListViewDynamicAdapter(getActivity());
        lv_list.setAdapter(adapter);
        return view;
    }

    private void initView(View view) {
        lv_list = view.findViewById(R.id.lv_list);
    }
}
