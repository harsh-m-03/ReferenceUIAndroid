package com.example.shoppingapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.shoppingapp.Adapter.CartAdapter;
import com.example.shoppingapp.Models.Items;
import com.example.shoppingapp.NavigationActivity;
import com.example.shoppingapp.databinding.FragmentCartBinding;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    FragmentCartBinding binding;
    CartAdapter adapter;
    String toastText = "Clicked";
    List<Items> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false);

        list = new ArrayList<>();
        list.add(new Items("Lemon Tea", 12.99f, 1, "Good day time"));
        list.add(new Items("Purple Tea", 9.99f, 1, "Good day time"));
        list.add(new Items("Bubble Tea", 10.99f, 1, "Good day time"));

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CartAdapter(getContext(), list);
        adapter.notifyDataSetChanged();
        binding.recyclerView.setAdapter(adapter);

        totalSetter();

        binding.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NavigationActivity.class);
                startActivity(intent);
            }
        });

        binding.total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalSetter();
            }
        });
        binding.totalText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalSetter();
            }
        });

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), toastText, Toast.LENGTH_SHORT).show();
            }
        });

        binding.totalItems.setText(String.valueOf(list.size()));

        return binding.getRoot();
    }

    void totalSetter() {
        float total = 0;

        for (Items items : list) {
            total += items.getPrice() * items.getQuantity();
        }

        binding.total.setText(String.valueOf(String.format("%.2f", total)));
    }
}