package com.example.test.MainFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.Adapter.VerticalBannerAdapter;
import com.example.test.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.taobao.library.VerticalBannerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TtFragment extends Fragment {


    private VerticalBannerView banner;
    private VerticalBannerAdapter adapter;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refresh;

    public TtFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tt, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
//        recyclerView = view.findViewById(R.id.recyclerView);
//        refresh = view.findViewById(R.id.refresh);
    }
}
