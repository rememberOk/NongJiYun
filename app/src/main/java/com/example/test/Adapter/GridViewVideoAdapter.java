package com.example.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.entity.FirstVideo;

import java.util.List;

public class GridViewVideoAdapter extends BaseAdapter {

    private Context context;
    private List<FirstVideo> firstVideos;

    public GridViewVideoAdapter(Context context, List<FirstVideo> firstVideos) {
        this.context = context;
        this.firstVideos = firstVideos;
    }

    @Override
    public int getCount() {
        return 4;
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
            view = LayoutInflater.from(context).inflate(R.layout.grid_view_video, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.gv_video_item.setText("你就是小猪佩奇就是");
        holder.gv_video_img.setImageResource(R.drawable.test3);

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView gv_video_item;
        public ImageView gv_video_img;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.gv_video_item = rootView.findViewById(R.id.gv_video_item);
            this.gv_video_img = rootView.findViewById(R.id.gv_video_img);

        }

    }
}
