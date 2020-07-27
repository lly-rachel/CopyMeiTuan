package com.example.copymt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridViewAdapter extends BaseAdapter {

    private List<IconInfo> itemData = new ArrayList<IconInfo>();
    private Context context;

    public GridViewAdapter(List<IconInfo> itemData, Context context) {
        this.itemData = itemData;
        this.context = context;
    }

    @Override
    public int getCount() { return itemData.size(); }

    @Override
    public Object getItem(int position) { return itemData.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.icon_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        IconInfo iconInfo = itemData.get(position);
        holder.icon_text.setText(iconInfo.iconName);
        holder.meituan_icon.setImageResource(iconInfo.iconID);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.meituan_icon) ImageView meituan_icon;
        @BindView(R.id.icon_text) TextView icon_text;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
