package com.example.test.MainFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.test.Activity.BtnAskActivity;
import com.example.test.Adapter.ListViewQueAdapter;
import com.example.test.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class QueFragment extends Fragment implements View.OnClickListener {


    private SmartRefreshLayout refresh;

    public QueFragment() {
        // Required empty public constructor
    }

    private ListViewQueAdapter QueAdapter;
    private ListView lv_que_item;
    private Button btn__que_ask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_que, container, false);
        initView(view);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });

        QueAdapter = new ListViewQueAdapter(getContext(), null);
        lv_que_item.setAdapter(QueAdapter);

        return view;
    }

    private void initView(View view) {
        lv_que_item = view.findViewById(R.id.lv_que_item);
        refresh = view.findViewById(R.id.refresh);
        btn__que_ask = view.findViewById(R.id.btn__que_ask);
        btn__que_ask.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn__que_ask:
                Intent intent = new Intent();
                intent.setClass(Objects.requireNonNull(getActivity()), BtnAskActivity.class);
                startActivity(intent);
        }
    }
}
