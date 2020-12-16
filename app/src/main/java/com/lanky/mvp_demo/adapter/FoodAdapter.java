package com.lanky.mvp_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanky.mvp_demo.R;
import com.lanky.mvp_demo.bean.FoodBean;

import java.util.List;

/**
 * LankyBin create on 2020/12/15
 */
public class FoodAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<FoodBean> foodBeanList;

    public FoodAdapter(Context context, List<FoodBean> foodBeanList){
        inflater = LayoutInflater.from(context);
        this.foodBeanList = foodBeanList;
    }

    @Override
    public int getCount() {
        return foodBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_adapter, null);
        }
        ViewHolder viewHolder = getViewHolder(convertView);
        viewHolder.tv_name.setText(foodBeanList.get(position).getName());
        viewHolder.tv_num.setText(foodBeanList.get(position).getNum() + "");
        return convertView;
    }

    private ViewHolder getViewHolder(View view) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        return viewHolder;
    }

    private class ViewHolder {
        private final TextView tv_name;
        private final TextView tv_num;

        private ViewHolder(View view) {
            tv_name = view.findViewById(R.id.tv_name);
            tv_num = view.findViewById(R.id.tv_num);
        }
    }
}
