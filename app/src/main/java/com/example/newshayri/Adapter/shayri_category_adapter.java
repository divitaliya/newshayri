package com.example.newshayri.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newshayri.Activity.shayri_category;
import com.example.newshayri.R;
import com.example.newshayri.config;

public class shayri_category_adapter extends BaseAdapter {

    shayri_category m;
    public shayri_category_adapter(shayri_category m) {
        this.m=m;
    }

    @Override
    public int getCount() {
        return config.shayari_img.length;
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

        convertView = LayoutInflater.from(m).inflate(R.layout.shayri_category_item,parent,false);
        TextView textView = convertView.findViewById(R.id.category_name);
        ImageView imageView = convertView.findViewById(R.id.category_img);

        textView.setText(config.shayari_name[position]);
        imageView.setImageResource(config.shayari_img[position]);


        return convertView;
    }
}
