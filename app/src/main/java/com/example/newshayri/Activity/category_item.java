package com.example.newshayri.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.newshayri.Adapter.category_item_adapter;
import com.example.newshayri.R;
import com.example.newshayri.config;

public class category_item extends AppCompatActivity {

    ListView listView;
    ActionBar actionBar;
    String[] temp;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_item);

        listView = findViewById(R.id.category_list);

        pos = getIntent().getIntExtra("pos",0);
        TextView textView = findViewById(R.id.category_item_name);

//        textView.setText("position"+pos+"\tcategory_name"+ config.shayari_name[pos]);

        actionBar = getSupportActionBar();
        actionBar.setTitle(config.shayari_name[pos]);

        if(pos==0)
        {
            temp = config.bestwishrsh;
        }
        if(pos==1)
        {
            temp = config.husband;
        }
        if(pos==3)
        {
            temp = config.child;
        }
        if(pos==4)
        {
            temp = config.god;
        }
        if(pos==5)
        {
            temp = config.motivation;
        }
        if(pos==6)
        {
            temp = config.kanjoos;
        }
        if(pos==7)
        {
            temp = config.marriid;
        }
        if(pos==8)
        {
            temp = config.santabanta;
        }
        if(pos==9)
        {
            temp = config.politics;
        }
        if(pos==10)
        {
            temp = config.love;
        }
        if(pos==11)
        {
            temp = config.sad;
        }
        if(pos==12)
        {
            temp = config.bearbar;
        }
        if(pos==13)
        {
            temp = config.bewfa;
        }
        if(pos==14)
        {
            temp = config.birthday;
        }
        if(pos==15)
        {
            temp = config.holiimg;
        }

        category_item_adapter category_item_adapter = new category_item_adapter(this,config.shayari_img[pos],temp);
        listView.setAdapter(category_item_adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(category_item.this,Shayri.class);
            intent.putExtra("pos",position);
            intent.putExtra("categorypos",temp);
            startActivity(intent);
        });

    }
}