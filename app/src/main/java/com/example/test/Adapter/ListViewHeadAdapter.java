package com.example.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.entity.FirstHead;

import java.util.List;

public class ListViewHeadAdapter extends BaseAdapter {

    private List<FirstHead> list;
    private Context context;

    public ListViewHeadAdapter(List<FirstHead> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
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
            view = LayoutInflater.from(context).inflate(R.layout.list_view_first, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.iv_first_img.setImageResource(R.drawable.test3);
        holder.tv_head_title.setText("20178年江苏乡村旅游节开幕首批精品线路");
        holder.tv_first_date.setText("2018-04-30");
        holder.tv_first_read.setText("401");
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView iv_first_img;
        public TextView tv_head_title;
        public TextView tv_first_date;
        public TextView tv_first_read;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_first_img = rootView.findViewById(R.id.iv_first_img);
            this.tv_head_title = rootView.findViewById(R.id.tv_head_title);
            this.tv_first_date = rootView.findViewById(R.id.tv_first_date);
            this.tv_first_read = rootView.findViewById(R.id.tv_first_read);
        }

    }
}
