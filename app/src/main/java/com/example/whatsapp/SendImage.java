package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.whatsapp.databinding.ActivitySendImageBinding;
import com.squareup.picasso.Picasso;

public class SendImage extends AppCompatActivity {

    ActivitySendImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        binding = ActivitySendImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent =  getIntent();
        String url = intent.getStringExtra("Url");
        Picasso.get().load(url).into(binding.setImage);

        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}