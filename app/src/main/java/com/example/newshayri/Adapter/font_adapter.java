package com.example.newshayri.Adapter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.newshayri.Activity.pencil;
import com.example.newshayri.R;
import com.example.newshayri.config;

public class font_adapter extends BaseAdapter {
    pencil pencil;
    public font_adapter(pencil pencil) {
        this.pencil=pencil;
    }

    @Override
    public int getCount() {
        return config.fonts.length;
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

        convertView = LayoutInflater.from(pencil).inflate(R.layout.font_item,parent,false);
        TextView fonttext = convertView.findViewById(R.id.fonttext);

        Typeface typeface = Typeface.createFromAsset(pencil.getAssets(),config.fonts[position]);
        fonttext.setTypeface(typeface);

        return convertView;
    }
}
