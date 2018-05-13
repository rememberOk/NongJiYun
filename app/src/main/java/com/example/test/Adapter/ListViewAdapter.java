package com.example.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.test.R;
import com.example.test.entity.QueAndExc;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListViewAdapter extends BaseAdapter {

    private List<QueAndExc> list;
    private Context context;

    public ListViewAdapter(List<QueAndExc> list, Context context) {
        this.list = list;
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_exc, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
//        QueAndExc queAndExc = list.get(i);
        holder.tv_que_author.setText("代答还");
        holder.iv_que_head_img.setImageResource(R.drawable.test2);
        holder.tv_que_self_addr.setText("南京市 浦口区");
        holder.tv_que_article.setText("鸡苗接种疫苗为什么会出现这红问题啊哈哈哈哈哈哈哈");
        holder.tv_que_date.setText("2018-04-29 13:11");

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public CircleImageView iv_que_head_img;
        public TextView tv_que_author;
        public TextView tv_que_self_addr;
        public TextView tv_que_article;
        public ImageView iv_que_body_img1;
        public ImageView iv_que_body_img2;
        public ImageView iv_que_body_img3;
        public TextView tv_que_date;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_que_head_img = rootView.findViewById(R.id.iv_que_head_img);
            this.tv_que_author =  rootView.findViewById(R.id.tv_que_author);
            this.tv_que_self_addr = rootView.findViewById(R.id.tv_que_self_addr);
            this.tv_que_article = rootView.findViewById(R.id.tv_que_article);
            this.iv_que_body_img1 = rootView.findViewById(R.id.iv_que_body_img1);
            this.iv_que_body_img2 = rootView.findViewById(R.id.iv_que_body_img2);
            this.iv_que_body_img3 = rootView.findViewById(R.id.iv_que_body_img3);
            this.tv_que_date = rootView.findViewById(R.id.tv_que_date);
        }

    }
}
