package com.example.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.entity.Farming;

import java.util.List;

public class ListViewFarmingAdapter extends BaseAdapter {

    private List<Farming> list;
    private Context context;

    public ListViewFarmingAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_farming_top,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (i < 5) {
            holder.farming_top.setVisibility(View.VISIBLE);
        } else {
            holder.farming_top.setVisibility(View.GONE);
        }
        holder.iv_farming_img.setImageResource(R.drawable.test3);
        holder.tv_farming_title.setText("啊哈哈哈啊哈哈哈哈哈哈");
        holder.tv_farming_body.setText("哦吼吼哦吼吼哦吼吼哦吼吼");
        holder.tv_farming_date.setText("2018-07-33");
        holder.tv_farming_read.setText("493");

        return view;
    }

    public static class ViewHolder {
        View rootView;
        public ImageView iv_farming_img;
        public TextView tv_farming_title;
        public TextView tv_farming_body;
        public TextView tv_farming_date;
        public TextView tv_farming_read;
        public TextView farming_top;

        ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_farming_img = rootView.findViewById(R.id.iv_farming_img);
            this.tv_farming_title = rootView.findViewById(R.id.tv_farming_title);
            this.tv_farming_body = rootView.findViewById(R.id.tv_farming_body);
            this.tv_farming_date = rootView.findViewById(R.id.tv_farming_date);
            this.tv_farming_read = rootView.findViewById(R.id.tv_farming_read);
            this.farming_top = rootView.findViewById(R.id.farming_top);
        }
    }
}
