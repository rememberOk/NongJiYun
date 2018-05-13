//package com.example.test.Activity;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.example.test.Adapter.FirstWeatherListAdapter;
//import com.example.test.R;
//import com.example.test.entity.Weather;
//
//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;
//
//public class WeatherActivity extends AppCompatActivity {
//    private ImageView menu_back_first;
//    private TextView tv_content_title;
//    private TextView city;
//    private TextView weather_date;
//    private TextView weather_temp;
//    private TextView weather_cloud;
//    private TextView weather_tq;
//    private ListView lv_weather;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_weather);
//        initView();
//        EventBus.getDefault().register(this);
//    }//<![CDATA[3-4级]]>9 -- 12
//    @SuppressLint("SetTextI18n")
//    @Subscribe (threadMode = ThreadMode.POSTING , sticky = true)
//    public void getWeather(Weather weather){
//        city.setText(weather.getCity());
//        Weather.ForecastBean bean = weather.getForecast().get(0);
//        weather_date.setText(bean.getDate());
//        weather_temp.setText(weather.getWendu()+"°");
//        weather_tq.setText(bean.getType());
//        weather_cloud.setText(bean.getFengxiang());
//        int lastIndex = bean.getFengli().lastIndexOf("]") - 1;
//        weather_cloud.append(bean.getFengli().substring(9,lastIndex));
//        FirstWeatherListAdapter adapter = new FirstWeatherListAdapter(weather.getForecast(),this);
//        lv_weather.setAdapter(adapter);
//    }
//
//    private void initView() {
//        menu_back_first = findViewById(R.id.menu_back_first);
//        tv_content_title = findViewById(R.id.tv_content_title);
//        city = findViewById(R.id.city);
//        weather_date = findViewById(R.id.weather_date);
//        weather_temp = findViewById(R.id.weather_temp);
//        weather_cloud = findViewById(R.id.weather_cloud);
//        weather_tq = findViewById(R.id.weather_tq);
//        lv_weather = findViewById(R.id.lv_weather);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        EventBus.getDefault().unregister(this);
//    }
//}
