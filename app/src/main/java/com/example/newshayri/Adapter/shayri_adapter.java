package com.example.newshayri.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.newshayri.Activity.Shayri;
import com.example.newshayri.R;
import com.example.newshayri.config;

public class shayri_adapter extends BaseAdapter {
    Shayri shayri;
    public shayri_adapter(Shayri shayri) {
        this.shayri=shayri;
    }

    @Override
    public int getCount() {
        return config.gradient.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(shayri).inflate(R.layout.gradient_item,parent,false);
        LinearLayout linearLayout = convertView.findViewById(R.id.gradient_item);
        linearLayout.setBackgroundResource(config.gradient[position]);

        return convertView;
    }
}
