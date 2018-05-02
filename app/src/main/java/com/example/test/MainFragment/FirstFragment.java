package com.example.test.MainFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.test.Adapter.GridViewAdapter;
import com.example.test.Activity.FirstMenuActivity;
import com.example.test.Adapter.GridViewVideoAdapter;
import com.example.test.Adapter.ListViewHeadAdapter;
import com.example.test.R;
import com.example.test.callback.OnListItemComponentsClick;
import com.example.test.entity.FirstVideo;
import com.example.test.util.MyGridView;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private GridView gv_menu;
    private MyGridView gv_first_video;
    private List<String> gridData;
    private GridViewAdapter adapter;
    private GridViewVideoAdapter videosAdapter;
    private ListViewHeadAdapter headAdapter;
    private ListView lv_list_head;
    public FirstFragment() {
        // Required empty public constructor
    }
    private RefreshLayout refreshLayout;
    private RollPagerView mRollViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        refreshLayout = view.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRollViewPager = view.findViewById(R.id.roll_view_pager);
        //设置播放时间间隔
        mRollViewPager.setPlayDelay(1000);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());
        //设置圆点指示器颜色得变化
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW, Color.WHITE));

        //GridView
        gridData = new ArrayList<>();
        gridData.add("品牌农资");
        gridData.add("应时农事");
        gridData.add("市场行情");
        gridData.add("农业科技");
        gridData.add("农业专家");
        gridData.add("农业政策");
        gridData.add("科技专项");
        gridData.add("农业合作");
        adapter = new GridViewAdapter(getActivity(),gridData);
        gv_menu.setAdapter(adapter);

        adapter.setOnListItemComponentsClick(new OnListItemComponentsClick() {
            @Override
            public void itemComponentsClick(String model) {
                Intent intent =  new Intent(getActivity(), FirstMenuActivity.class);
                switch (model) {
                    case "品牌农资":
                        intent.putExtra("model",1);
                        startActivity(intent);
                        break;
                    case "应时农事":
                        intent.putExtra("model",2);
                        startActivity(intent);
                        break;
                    case "市场行情":
                        intent.putExtra("model",3);
                        startActivity(intent);
                        break;
                    case "农业科技":
                        intent.putExtra("model",4);
                        startActivity(intent);
                        break;
                    case "农业专家":
                        intent.putExtra("model",5);
                        startActivity(intent);
                        break;
                    case "农业政策":
                        intent.putExtra("model",6);
                        startActivity(intent);
                        break;
                    case "科技专项":
                        intent.putExtra("model",7);
                        startActivity(intent);
                        break;
                    case "农业合作":
                        intent.putExtra("model",8);
                        startActivity(intent);
                        break;
                }
            }
        });

//        ListView
        headAdapter = new ListViewHeadAdapter(null,getActivity());
        lv_list_head.setAdapter(headAdapter);


        videosAdapter = new GridViewVideoAdapter(getActivity(), null);
        gv_first_video.setAdapter(videosAdapter);
    }

    private void initView(View view) {
        gv_menu = view.findViewById(R.id.gv_menu);
        lv_list_head = view.findViewById(R.id.lv_list_head);
        gv_first_video = view.findViewById(R.id.gv_first_video);
    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.img_1,
                R.drawable.img_2,
                R.drawable.img_3,
                R.drawable.img_4,
                R.drawable.img_5,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
