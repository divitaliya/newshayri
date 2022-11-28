package com.example.newshayri.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.newshayri.Activity.pencil;
import com.example.newshayri.R;
import com.example.newshayri.config;

public class background_adapter extends BaseAdapter {
    pencil pencil;
    public background_adapter(pencil pencil) {
        this.pencil=pencil;
    }

    @Override
    public int getCount() {
        return config.colors.length;
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

        convertView= LayoutInflater.from(pencil).inflate(R.layout.background_item,parent,false);
        LinearLayout textview=convertView.findViewById(R.id.view);
        textview.setBackgroundColor(pencil.getResources().getColor(config.colors[position]));

        return convertView;
    }
}
