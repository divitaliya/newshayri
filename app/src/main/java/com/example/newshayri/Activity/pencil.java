package com.example.newshayri.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newshayri.Adapter.background_adapter;
import com.example.newshayri.Adapter.emoji_adapter;
import com.example.newshayri.Adapter.font_adapter;
import com.example.newshayri.Adapter.gradient_adapter;
import com.example.newshayri.R;
import com.example.newshayri.config;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class pencil extends AppCompatActivity {

    TextView textView;
    Button back,textcolor,font,share,emoji,textsize;
    String text;
    LinearLayout linearLayout,linear;
    GridView gridView,emojiview,fontgrid;
    ImageView expand,reload,downlode;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencil);


        textView = findViewById(R.id.hello);
        text = getIntent().getStringExtra("shayri");
        textView.setText(text);

        back = findViewById(R.id.background);
        textcolor = findViewById(R.id.textcolor);
        font = findViewById(R.id.font);
        share = findViewById(R.id.share);
        emoji = findViewById(R.id.emoji);
        textsize = findViewById(R.id.textsize);
        linearLayout = findViewById(R.id.view);
        linear = findViewById(R.id.linear);
        reload = findViewById(R.id.reload);
        expand = findViewById(R.id.expand);
        downlode = findViewById(R.id.down);

        downlode.setOnClickListener(v -> {
            Bitmap icon = getBitmapFromView(linear);
            System.out.println("bitmap=="+icon);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            int randam = new Random().nextInt(2000);
            File f = new File(config.file.getAbsolutePath()+"/shayri"+"img_file"+randam+".jpg");
            try {
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
                Toast.makeText(this, "downlode file", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        reload.setOnClickListener(v -> {
            int min=0;
            int max=config.gradient.length;
            int random = new Random().nextInt(max-min)+min;
            textView.setBackgroundResource(config.gradient[random]);
        });
        textsize.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);

            View view = LayoutInflater.from(this).inflate(R.layout.textsize_layout,null);

            seekBar = view.findViewById(R.id.seekBar);

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar s, int progress, boolean fromUser) {
                    textView.setTextSize(s.getProgress());
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();
        });
        expand.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setCancelable(false);

            View view = LayoutInflater.from(this).inflate(R.layout.gradient_layout,null);

            gridView = view.findViewById(R.id.gradient_grid);

            gradient_adapter gradient_adapter = new gradient_adapter(this);
            gridView.setAdapter(gradient_adapter);

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
        back.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setCancelable(false);

            View view = LayoutInflater.from(this).inflate(R.layout.background_layout,null);

            gridView = view.findViewById(R.id.grid);

            background_adapter background_adapter = new background_adapter(this);
            gridView.setAdapter(background_adapter);

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();


            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    textView.setBackgroundColor(getResources().getColor(config.colors[position]));
                    bottomSheetDialog.setCancelable(true);
                }
            });
        });
        textcolor.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setCancelable(false);

            View view = LayoutInflater.from(this).inflate(R.layout.background_layout,null);

            gridView = view.findViewById(R.id.grid);

            background_adapter background_adapter = new background_adapter(this);
            gridView.setAdapter(background_adapter);

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    textView.setTextColor(getResources().getColor(config.colors[position]));
                    bottomSheetDialog.setCancelable(true);
                }
            });
        });
        share.setOnClickListener(v -> {
            Bitmap icon = getBitmapFromView(linear);
            System.out.println("bitmap=="+icon);
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            int randam = new Random().nextInt(2000);
            File f = new File(config.file.getAbsolutePath()+"/shayri"+"img_file"+randam+".jpg");
            try {
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
            share.putExtra(Intent.EXTRA_STREAM, Uri.parse(f.getAbsolutePath()));
            startActivity(Intent.createChooser(share, "Share Image"));
        });
        font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencil.this);

                v = LayoutInflater.from(pencil.this).inflate(R.layout.font_layout,null);
                fontgrid = v.findViewById(R.id.fontgrid);

                font_adapter font_adapter = new font_adapter(pencil.this);
                fontgrid.setAdapter(font_adapter);

                bottomSheetDialog.setContentView(v);
                bottomSheetDialog.show();
                fontgrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Typeface typeface = Typeface.createFromAsset(getAssets(),config.fonts[position]);
                        textView.setTypeface(typeface);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });
        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencil.this);
                bottomSheetDialog.setCancelable(false);

                v = LayoutInflater.from(pencil.this).inflate(R.layout.emoji_layout,null);

                emojiview = v.findViewById(R.id.emojigrid);

                emoji_adapter emoji_adapter = new emoji_adapter(pencil.this);
                emojiview.setAdapter(emoji_adapter);

                bottomSheetDialog.setContentView(v);
                bottomSheetDialog.show();

                emojiview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView.setText(config.emoji[position]+"\n"+text+"\n"+config.emoji[position]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });
    }
    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }
}