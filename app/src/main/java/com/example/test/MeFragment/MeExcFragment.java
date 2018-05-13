package com.example.test.MeFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.test.Adapter.ListViewAdapter;
import com.example.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeExcFragment extends Fragment {

    private ListView lv_ft_exc;

    public MeExcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exc_me, container, false);
        initView(view);

        ListViewAdapter adapter = new ListViewAdapter(null, getContext());
        lv_ft_exc.setAdapter(adapter);
        return view;
    }

    private void initView(View view) {
        lv_ft_exc = view.findViewById(R.id.lv_ft_exc);
    }
}
