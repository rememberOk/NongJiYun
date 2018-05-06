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
import com.example.test.entity.RedListView;

import java.util.List;

public class ListViewFocusAdapter extends BaseAdapter {

    private Context context;
    private List<RedListView> list;

    public ListViewFocusAdapter(Context context, List<RedListView> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null ) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_top_one, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (i < 5) {
            holder.top_tag.setVisibility(View.VISIBLE);
        } else {
            holder.top_tag.setVisibility(View.GONE);
        }

        holder.iv_top_img.setImageResource(R.drawable.test3);
        holder.tv_top_title.setText("啊哈哈哈哈哈哈");
        holder.tv_top_come.setText("中国日报");
        holder.tv_top_date.setText("2018-04-28");
        holder.tv_top_read.setText("545");
        holder.tv_top_tag1.setText("市场");
        holder.tv_top_tag2.setText("主推");
        holder.tv_top_tag3.setVisibility(View.GONE);

        return view;
    }

    public static class ViewHolder {
        View rootView;
        public ImageView iv_top_img;
        public TextView top_tag;
        public TextView tv_top_title;
        public TextView tv_top_come;
        public TextView tv_top_date;
        public ImageView icon_look;
        public TextView tv_top_read;
        public TextView tv_top_tag1;
        public TextView tv_top_tag2;
        public TextView tv_top_tag3;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_top_img = rootView.findViewById(R.id.iv_top_img);
            this.top_tag = rootView.findViewById(R.id.top_tag);
            this.tv_top_title = rootView.findViewById(R.id.tv_top_title);
            this.tv_top_come = rootView.findViewById(R.id.tv_top_come);
            this.tv_top_date = rootView.findViewById(R.id.tv_top_date);
            this.icon_look = rootView.findViewById(R.id.icon_look);
            this.tv_top_read = rootView.findViewById(R.id.tv_top_read);
            this.tv_top_tag1 = rootView.findViewById(R.id.tv_top_tag1);
            this.tv_top_tag2 = rootView.findViewById(R.id.tv_top_tag2);
            this.tv_top_tag3 = rootView.findViewById(R.id.tv_top_tag3);
        }

    }
}
