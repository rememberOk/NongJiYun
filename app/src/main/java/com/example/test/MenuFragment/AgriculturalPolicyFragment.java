package com.example.test.MenuFragment;


import android.os.Bundle;
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
public class AgriculturalPolicyFragment extends Fragment {


    private ListView lv_list_policy;

    public AgriculturalPolicyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agricultural_policy, container, false);

        initView(view);
        ListViewFarmingAdapter farmingAdapter = new ListViewFarmingAdapter(getActivity());
        lv_list_policy.setAdapter(farmingAdapter);

        return view;
    }

    private void initView(View view) {
        lv_list_policy = view.findViewById(R.id.lv_list_policy);
    }
}
