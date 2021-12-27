package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.whatsapp.databinding.ActivitySendImageBinding;
import com.squareup.picasso.Picasso;

public class SendImage extends AppCompatActivity{

    ActivitySendImageBinding binding;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        binding = ActivitySendImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*Intent intent =  getIntent();
        url = intent.getStringExtra("Url");
        Picasso.get().load(url).into(binding.setImage);

        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SendImage.this, ChatDetailActivity.class);
                i.putExtra("Url", url);
                startActivity(i);
            }
        });*/

    }
}