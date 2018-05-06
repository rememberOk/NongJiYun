package com.example.test.MenuFragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.test.Adapter.ListViewFarmingAdapter;
import com.example.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FarmingFragment extends Fragment {


    private ListViewFarmingAdapter farmingAdapter;
    private ListView lv_list_farming;

    public FarmingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_farming, container, false);
        initView(view);


        farmingAdapter = new ListViewFarmingAdapter(getActivity());
        lv_list_farming.setAdapter(farmingAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initView(View view) {
        lv_list_farming = (ListView) view.findViewById(R.id.lv_list_farming);
    }
}
