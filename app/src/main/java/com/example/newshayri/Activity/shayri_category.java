package com.example.newshayri.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.PagerAdapter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;
import android.widget.Toast;

import com.example.newshayri.Adapter.shayri_category_adapter;
import com.example.newshayri.R;
import com.example.newshayri.config;

import java.io.File;
import java.util.List;

public class shayri_category extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shayri_category);

        ActivityCompat.requestPermissions(shayri_category.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);

        list = findViewById(R.id.list);

        shayri_category_adapter shayri_category_adapter = new shayri_category_adapter(this);
        list.setAdapter(shayri_category_adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(shayri_category.this,category_item.class);
            intent.putExtra("pos",position);
            startActivity(intent);
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {


                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    config.file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)+"/shayri");
                    if(config.file.exists())
                    {
                        System.out.println("folder is avilable");
                    }
                    else
                    {
                        System.out.println("folder is not avilable");
                        if(config.file.mkdir())
                        {
                            System.out.println("create folder");
                        }
                        else{
                            System.out.println("not create folder");
                        }
                    }
                } else {
                    ActivityCompat.requestPermissions(shayri_category.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            1);
                    Toast.makeText(shayri_category.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}