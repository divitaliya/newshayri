package com.example.newshayri.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.newshayri.Activity.pencil;
import com.example.newshayri.R;
import com.example.newshayri.config;

public class emoji_adapter extends BaseAdapter {

    pencil pencil;
    public emoji_adapter(pencil pencil) {
        this.pencil=pencil;
    }

    @Override
    public int getCount() {
        return config.emoji.length;
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

        convertView = LayoutInflater.from(pencil).inflate(R.layout.emoji_item,parent,false);
        TextView textView = convertView.findViewById(R.id.emojiview);
        textView.setText(config.emoji[position]);


        return convertView;
    }
}
