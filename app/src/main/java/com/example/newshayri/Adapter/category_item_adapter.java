package com.example.newshayri.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newshayri.Activity.category_item;
import com.example.newshayri.R;
import com.example.newshayri.config;

import org.w3c.dom.Text;

public class category_item_adapter extends BaseAdapter {
    category_item a;
    int img;
    String[] temp;
    public category_item_adapter(category_item a, int img, String[] temp) {
        this.a=a;
        this.img=img;
        this.temp=temp;
    }

    @Override
    public int getCount() {
        return temp.length;
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

        convertView = LayoutInflater.from(a).inflate(R.layout.category_item_item,parent,false);

        ImageView imageView = convertView.findViewById(R.id.category_item_img);
        imageView.setImageResource(img);
        TextView textView = convertView.findViewById(R.id.category_item_name);
        textView.setText(temp[position]);

        return convertView;
    }
}
