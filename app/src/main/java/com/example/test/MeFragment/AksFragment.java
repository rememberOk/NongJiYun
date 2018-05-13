package com.example.test.MeFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.test.Adapter.ListViewQueAdapter;
import com.example.test.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AksFragment extends Fragment {


    private ListView lv_ft_ask;

    public AksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aks, container, false);
        initView(view);

        ListViewQueAdapter queAdapter = new ListViewQueAdapter(getActivity(),null);
        lv_ft_ask.setAdapter(queAdapter);
        return view;
    }

    private void initView(View view) {
        lv_ft_ask = view.findViewById(R.id.lv_ft_ask);
    }
}
