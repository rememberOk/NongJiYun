package com.example.test.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.test.R;
import com.example.test.entity.VerticalBanner;
import com.taobao.library.BaseBannerAdapter;
import com.taobao.library.VerticalBannerView;

import java.util.List;

public class VerticalBannerAdapter extends BaseBannerAdapter<VerticalBanner> {

    public VerticalBannerAdapter(List<VerticalBanner> datas) {
        super(datas);
    }

    @Override
    public View getView(VerticalBannerView verticalBannerView) {
        View view = LayoutInflater.from(verticalBannerView.getContext()).inflate(R.layout.list_item_news, null);
        return view;
    }

    @Override
    public void setItem(View view, VerticalBanner verticalBanner) {
        TextView text = view.findViewById(R.id.text);
        text.setText(verticalBanner.getInfo());
    }

    public static class ViewHolder {
        public View rootView;
        public TextView text;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.text = rootView.findViewById(R.id.text);
        }
    }
}
