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

import java.net.PortUnreachableException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListViewQueAdapter extends BaseAdapter {

    private Context context;
    private List<QueAndExc> list;

    public ListViewQueAdapter(Context context, List<QueAndExc> list) {
        this.context = context;
        this.list = list;
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
            view = LayoutInflater.from(context).inflate(R.layout.list_item_que, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.iv_que_head_img.setImageResource(R.drawable.test3);
        holder.tv_que_author.setText("小猪佩奇");
        holder.tv_que_self_addr.setText("江苏省南京市栖霞区东东嘻嘻");
        holder.tv_que_article.setText("嗯....我们来讨论一下恩恩恩恩嫩恩呢呢，我也不知道说什么课哈哈哈哈");
        holder.iv_que_body_img1.setImageResource(R.drawable.test4);
        holder.iv_que_body_img2.setImageResource(R.drawable.test4);
        holder.iv_que_body_img3.setImageResource(R.drawable.test4);
        holder.tv_que_body_addr.setText("江苏省南京市浦口区咚咚咚能够");
        holder.tv_que_date.setText("2018-04-21 14:22");
        holder.tv_que_like.setText("200");
        holder.tv_que_comment.setText("20000+");
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
        public TextView tv_que_body_addr;
        public TextView tv_que_date;
        public TextView tv_que_like;
        public TextView tv_que_comment;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_que_head_img = rootView.findViewById(R.id.iv_que_head_img);
            this.tv_que_author = rootView.findViewById(R.id.tv_que_author);
            this.tv_que_self_addr = rootView.findViewById(R.id.tv_que_self_addr);
            this.tv_que_article = rootView.findViewById(R.id.tv_que_article);
            this.iv_que_body_img1 = rootView.findViewById(R.id.iv_que_body_img1);
            this.iv_que_body_img2 = rootView.findViewById(R.id.iv_que_body_img2);
            this.iv_que_body_img3 = rootView.findViewById(R.id.iv_que_body_img3);
            this.tv_que_body_addr = rootView.findViewById(R.id.tv_que_body_addr);
            this.tv_que_date = rootView.findViewById(R.id.tv_que_date);
            this.tv_que_like = rootView.findViewById(R.id.tv_que_like);
            this.tv_que_comment = rootView.findViewById(R.id.tv_que_comment);
        }

    }
}
