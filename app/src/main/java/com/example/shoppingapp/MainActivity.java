package com.example.shoppingapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.shoppingapp.Fragments.CartFragment;
import com.example.shoppingapp.Fragments.HomeFragment;
import com.example.shoppingapp.Fragments.StoreFragment;
import com.example.shoppingapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Initialization();

        getSupportFragmentManager().beginTransaction().replace(R.id.body, new HomeFragment()).commit();
        binding.bottomNav.setSelectedItemId(R.id.nav_home);

        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_store:
                        fragment = new StoreFragment();
                        break;
                    case R.id.nav_cart:
                        fragment = new CartFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body, fragment).commit();
                return true;
            }


        });
    }

    void Initialization() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}