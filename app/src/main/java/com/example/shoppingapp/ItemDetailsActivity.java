package com.example.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shoppingapp.databinding.ActivityItemDetailsBinding;

import java.util.Objects;

public class ItemDetailsActivity extends AppCompatActivity {
    ActivityItemDetailsBinding binding;
    String toastText = "Clicked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Initialization();

        String itemName=getIntent().getStringExtra("ItemName");
        String itemNote=getIntent().getStringExtra("ItemNote");
        String price=getIntent().getStringExtra("Price");

        binding.price.setText(price);
        binding.itemName.setText(itemName);
        binding.itemNote.setText(itemNote);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemDetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemDetailsActivity.this, toastText, Toast.LENGTH_SHORT).show();
            }
        });
        binding.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemDetailsActivity.this, toastText, Toast.LENGTH_SHORT).show();
            }
        });
        binding.restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemDetailsActivity.this, toastText, Toast.LENGTH_SHORT).show();
            }
        });

    }

    void Initialization() {
        binding = ActivityItemDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}