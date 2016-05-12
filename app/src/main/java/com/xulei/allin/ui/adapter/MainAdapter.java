package com.xulei.allin.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xulei.allin.R;
import com.xulei.allin.model.MenuModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xulei on 2016/5/12.
 */
public class MainAdapter extends BaseAdapter<MenuModel> {

    public MainAdapter(Context context, List<MenuModel> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            convertView = inflate(R.layout.item_main, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.iv.setImageResource(getItem(position).getResId());
        holder.tv.setText(getItem(position).getName());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.id_item_main_iv)
        ImageView iv;
        @Bind(R.id.id_item_main_tv)
        TextView tv;

        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
