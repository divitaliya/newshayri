package com.example.newshayri.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newshayri.Adapter.gradient_adapter;
import com.example.newshayri.Adapter.shayri_adapter;
import com.example.newshayri.R;
import com.example.newshayri.config;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Random;

public class Shayri extends AppCompatActivity {
//    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
    ImageView pencil,copy,prev,next,share,relode,expand;
    int shayripos;
    String[] arr;
    TextView textView,title;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri);

        pencil = findViewById(R.id.pencil);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        copy = findViewById(R.id.copy);
        share = findViewById(R.id.share);
        textView = findViewById(R.id.page);
        title = findViewById(R.id.title);
        relode = findViewById(R.id.reload);
        expand = findViewById(R.id.expand);

        shayripos = getIntent().getIntExtra("pos",0);
        arr = getIntent().getStringArrayExtra("categorypos");

        textView.setText(arr[shayripos]);
        title.setText((shayripos+1)+"/"+ arr.length);

        copy.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("label", arr[shayripos]);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "copied", Toast.LENGTH_SHORT).show();
        });
        prev.setOnClickListener(v -> {
            if(shayripos>0)
            {
                shayripos--;
                textView.setText(arr[shayripos]);
                title.setText((shayripos+1)+"/"+ arr.length);
            }
        });
        pencil.setOnClickListener(v -> {
            Intent intent = new Intent(Shayri.this,pencil.class);
            intent.putExtra("shayri",textView.getText().toString());
            startActivity(intent);
        });
        next.setOnClickListener(v -> {
            if(shayripos< arr.length-1)
            {
                shayripos++;
                textView.setText(arr[shayripos]);
                title.setText((shayripos+1)+"/"+ arr.length);
            }
        });
        share.setOnClickListener(v -> {
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            String shareBody = arr[shayripos];
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(intent,"share"));
        });
        relode.setOnClickListener(v -> {
            int min=0;
            int max= config.gradient.length;
            int random = new Random().nextInt(max-min)+min;
            textView.setBackgroundResource(config.gradient[random]);
        });
        expand.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setCancelable(false);

            View view = LayoutInflater.from(this).inflate(R.layout.gradient_layout,null);

            gridView = view.findViewById(R.id.gradient_grid);

            shayri_adapter shayri_adapter = new shayri_adapter(this);
            gridView.setAdapter(shayri_adapter);

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();


            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    textView.setBackgroundResource(config.gradient[position]);
                    bottomSheetDialog.setCancelable(true);
                }
            });
        });

    }
}