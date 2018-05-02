package com.example.test.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import com.example.test.R;
import com.example.test.callback.OnListItemComponentsClick;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private List<String> gridData;
    private OnListItemComponentsClick onListItemComponentsClick;

    public void setOnListItemComponentsClick(OnListItemComponentsClick onListItemComponentsClick) {
        this.onListItemComponentsClick = onListItemComponentsClick;
    }

    public GridViewAdapter(Context context, List<String> gridData) {
        this.context = context;
        this.gridData = gridData;
    }

    @Override
    public int getCount() {
        return gridData.size() + 1;
    }

    @Override
    public Object getItem(int i) {
        return gridData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        if (i==gridData.size()){
            holder.rb_menu1.setText("更多");
            holder.rb_menu1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onListItemComponentsClick.itemComponentsClick("更多");
                }
            });
        }else {
            holder.rb_menu1.setText(gridData.get(i));
            holder.rb_menu1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onListItemComponentsClick.itemComponentsClick(gridData.get(i));
                }
            });
        }
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public RadioButton rb_menu1;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.rb_menu1 = rootView.findViewById(R.id.rb_menu1);
        }
    }
}
