package com.example.test.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.test.R;

public class SystemAdapter extends BaseAdapter {
    private Context context;

    public SystemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_system, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_body.setText("目前部分处于3叶期的春雨米田地，受地老虎等害虫危害严重，专家提醒防治");
        holder.tv_date.setText("2019-04-25");
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_body;
        public TextView tv_date;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_date = rootView.findViewById(R.id.tv_date);
            this.tv_body = rootView.findViewById(R.id.tv_body);
        }

    }
}
