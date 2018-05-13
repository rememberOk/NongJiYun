package com.example.test.MainFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.test.Activity.FirstMenuActivity;
import com.example.test.Activity.FirstMoreActivity;
import com.example.test.Activity.NoticeActivity;
import com.example.test.Activity.VideoActivity;
//import com.example.test.Activity.WeatherActivity;
import com.example.test.Adapter.GridViewAdapter;
import com.example.test.Adapter.ListViewHeadAdapter;
import com.example.test.Adapter.VerticalBannerAdapter;
import com.example.test.R;
import com.example.test.callback.OnListItemComponentsClick;
import com.example.test.entity.VerticalBanner;
import com.example.test.entity.Weather;
import com.google.gson.Gson;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.taobao.library.VerticalBannerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

//import com.alibaba.fastjson.JSON;

public class FirstFragment extends Fragment implements View.OnClickListener {
    private GridView gv_menu;
    private ListView lv_list_head;
    private VerticalBannerView first_banner;
    private ImageView videoOne;
    private TextView tv_weather_today;
    private TextView tv_weather_date;
    private TextView tv_weather_city;
    private TextView tv_weather_temp;
    private TextView tv_weather_type;
    private Button btn_first;
    private ImageView iv_notice;
    private RollPagerView roll_view_pager;
    private RadioButton rb_head;
    private RadioButton rb_dynamic;
    private RadioButton rb_video;
    private ImageView iv_videoOne;
    private LinearLayout ll_home_weather;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        initView(view);

        RefreshLayout refreshLayout = view.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        //上拉加载
//        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
//            @Override
//            public void onLoadmore(RefreshLayout refreshlayout) {
//                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
//            }
//        });
//        getWeather();
//
//        Weather weather = new Weather();
//        List<Weather.ForecastBean> forecast = weather.getForecast();
//        tv_weather_temp.setText(forecast.get(0).getHigh());
//        tv_weather_type.setText(forecast.get(0).getType());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        getWeather();
        RollPagerView mRollViewPager = view.findViewById(R.id.roll_view_pager);
        //设置播放时间间隔
        mRollViewPager.setPlayDelay(1000);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());
        //设置圆点指示器颜色得变化
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW, Color.WHITE));

        //GridView
        List<String> gridData = new ArrayList<>();
        gridData.add("品牌农资");
        gridData.add("应时农事");
        gridData.add("市场行情");
        gridData.add("农业科技");
        gridData.add("农业专家");
        gridData.add("农业政策");
        gridData.add("科技专项");
        gridData.add("专业合作");
        GridViewAdapter adapter = new GridViewAdapter(getActivity(), gridData);
        gv_menu.setAdapter(adapter);

        adapter.setOnListItemComponentsClick(new OnListItemComponentsClick() {
            @Override
            public void itemComponentsClick(String model) {
                Intent intent = new Intent(getActivity(), FirstMenuActivity.class);
                switch (model) {
                    case "品牌农资":
                        intent.putExtra("model", 1);
                        startActivity(intent);
                        break;
                    case "应时农事":
                        intent.putExtra("model", 2);
                        startActivity(intent);
                        break;
                    case "市场行情":
                        intent.putExtra("model", 3);
                        startActivity(intent);
                        break;
                    case "农业科技":
                        intent.putExtra("model", 4);
                        startActivity(intent);
                        break;
                    case "农业专家":
                        intent.putExtra("model", 5);
                        startActivity(intent);
                        break;
                    case "农业政策":
                        intent.putExtra("model", 6);
                        startActivity(intent);
                        break;
                    case "科技专项":
                        intent.putExtra("model", 7);
                        startActivity(intent);
                        break;
                    case "专业合作":
                        intent.putExtra("model", 8);
                        startActivity(intent);
                        break;
                }
            }
        });

//        ListView
        ListViewHeadAdapter headAdapter = new ListViewHeadAdapter(null, getActivity());
        lv_list_head.setAdapter(headAdapter);

        super.onViewCreated(view, savedInstanceState);
        List<VerticalBanner> data = new ArrayList<>();
        data.add(new VerticalBanner("王浩小垃圾"));
        data.add(new VerticalBanner("王浩小垃圾"));
        data.add(new VerticalBanner("王浩小垃圾"));
        data.add(new VerticalBanner("王浩小垃圾"));
        data.add(new VerticalBanner("王浩小垃圾"));
        VerticalBannerAdapter bannerAdapter = new VerticalBannerAdapter(data);
        first_banner.setAdapter(bannerAdapter);
        first_banner.start();
    }

    //    天气
//    private void getWeather() {
//        OkHttpUtils.get()
//                .url("http://wthrcdn.etouch.cn/weather_mini?citykey=101190101")
//                .build()
//                .execute(new StringCallback() {
//            @Override
//            public void onError(Call call, Exception e, int id) {
//
//            }
//
//            @Override
//            public void onResponse(String response, int id) {
//                JSONObject object = null;
//                try {
//                    object = new JSONObject(response);
//                    JSONObject jsonObject = object.getJSONObject("data");
//                    final Weather weather = new Gson().fromJson(jsonObject.toString(), Weather.class);
//                    EventBus.getDefault().postSticky(weather);
//                    tv_weather_city.setText(weather.getCity());
//                    tv_weather_temp.setText(weather.getWendu() + "°");
//                    Weather.ForecastBean forecast = weather.getForecast().get(0);
//                    tv_weather_type.setText(forecast.getType());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    @SuppressLint("CutPasteId")
    private void initView(View view) {
        gv_menu = view.findViewById(R.id.gv_menu);
        lv_list_head = view.findViewById(R.id.lv_list_head);
        first_banner = view.findViewById(R.id.first_banner);
        RadioButton rb_head = view.findViewById(R.id.rb_head);
        rb_head.setOnClickListener(this);
        RadioButton rb_dynamic = view.findViewById(R.id.rb_dynamic);
        rb_dynamic.setOnClickListener(this);
        RadioButton rb_video = view.findViewById(R.id.rb_video);
        rb_video.setOnClickListener(this);
        ImageView iv_notice = view.findViewById(R.id.iv_notice);
        iv_notice.setOnClickListener(this);
        videoOne = view.findViewById(R.id.iv_videoOne);
        videoOne.setOnClickListener(this);
        tv_weather_today = view.findViewById(R.id.tv_weather_today);
        tv_weather_today.setOnClickListener(this);
        tv_weather_date = view.findViewById(R.id.tv_weather_date);
        tv_weather_date.setOnClickListener(this);
        tv_weather_city = view.findViewById(R.id.tv_weather_city);
        tv_weather_city.setOnClickListener(this);
        tv_weather_temp = view.findViewById(R.id.tv_weather_temp);
        tv_weather_temp.setOnClickListener(this);
        tv_weather_type = view.findViewById(R.id.tv_weather_type);
        tv_weather_type.setOnClickListener(this);
        btn_first = view.findViewById(R.id.btn_first);
        btn_first.setOnClickListener(this);
        iv_notice = view.findViewById(R.id.iv_notice);
        iv_notice.setOnClickListener(this);
        roll_view_pager = view.findViewById(R.id.roll_view_pager);
        roll_view_pager.setOnClickListener(this);
        rb_head = view.findViewById(R.id.rb_head);
        rb_head.setOnClickListener(this);
        rb_dynamic = view.findViewById(R.id.rb_dynamic);
        rb_dynamic.setOnClickListener(this);
        rb_video = view.findViewById(R.id.rb_video);
        rb_video.setOnClickListener(this);
        iv_videoOne = view.findViewById(R.id.iv_videoOne);
        iv_videoOne.setOnClickListener(this);
        ll_home_weather = view.findViewById(R.id.ll_home_weather);
        ll_home_weather.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_head:
                Intent intent = new Intent(getActivity(), FirstMoreActivity.class);
                intent.putExtra("num", 1);
                startActivity(intent);
                break;
            case R.id.rb_dynamic:
                Intent intentD = new Intent(getActivity(), FirstMoreActivity.class);
                intentD.putExtra("num", 2);
                startActivity(intentD);
                break;
            case R.id.rb_video:
                Intent intentV = new Intent(getActivity(), FirstMoreActivity.class);
                intentV.putExtra("num", 3);
                startActivity(intentV);
                break;
            case R.id.iv_notice:
                Intent intentN = new Intent(getActivity(), NoticeActivity.class);
                startActivity(intentN);
                break;
            case R.id.iv_videoOne:
                Intent intent1 = new Intent(getActivity(), VideoActivity.class);
                intent1.putExtra("url", "http://object.jsnjy.net.cn/OSS/20180504/54133.mp4");
                startActivity(intent1);
            case R.id.btn_first:
                break;
//            case R.id.tv_weather_city:
//            case R.id.tv_weather_today:
//            case R.id.tv_weather_date:
//            case R.id.tv_weather_temp:
//            case R.id.tv_weather_type:
//                Intent intentW = new Intent(getActivity(), WeatherActivity.class);
//                startActivity(intentW);
//                break;
        }
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
