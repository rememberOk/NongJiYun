package com.example.test.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

public class ListViewDynamicAdapter extends BaseAdapter {

    private Context context;

    public ListViewDynamicAdapter(Context context) {
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
            view = LayoutInflater.from(context).inflate(R.layout.list_view_brand, null);

            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (i < 3) {
            holder.brand_tag_top.setVisibility(View.VISIBLE);
        } else {
            holder.brand_tag_top.setVisibility(View.GONE);
        }
        holder.iv_first_img.setImageResource(R.drawable.test4);
        holder.tv_head_title.setText("嗯哈哈哈哈哈嗯哼嘿哈嘿哈哈啦啦啦啦啦啦啦");
        holder.tv_first_read.setText("4365");
        holder.tv_first_date.setText("2019-04-24");
        return view;
    }
    public static class ViewHolder {
        public View rootView;
        public ImageView iv_first_img;
        public TextView tv_head_title;
        public ImageView icon_look;
        public TextView tv_first_read;
        public TextView tv_first_date;
        public TextView brand_tag;
        public TextView brand_tag_top;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_first_img = rootView.findViewById(R.id.iv_first_img);
            this.tv_head_title = rootView.findViewById(R.id.tv_head_title);
            this.icon_look = rootView.findViewById(R.id.icon_look);
            this.tv_first_read = rootView.findViewById(R.id.tv_first_read);
            this.tv_first_date = rootView.findViewById(R.id.tv_first_date);
            this.brand_tag = rootView.findViewById(R.id.brand_tag);
            this.brand_tag_top = rootView.findViewById(R.id.brand_tag_top);
        }

    }
}
