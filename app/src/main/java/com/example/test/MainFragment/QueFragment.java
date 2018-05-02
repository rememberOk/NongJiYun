package com.example.test.MainFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.test.Adapter.ListViewQueAdapter;
import com.example.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QueFragment extends Fragment {


    public QueFragment() {
        // Required empty public constructor
    }

    private ListViewQueAdapter QueAdapter;
    private ListView lv_que_item;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_que, container, false);
        initView(view);
        QueAdapter = new ListViewQueAdapter(getContext(),null);
        lv_que_item.setAdapter(QueAdapter);
        return  view;
    }
    private void initView(View view) {
        lv_que_item = view.findViewById(R.id.lv_que_item);
    }

}
