package com.example.shoppingapp.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.shoppingapp.Adapter.HomePageDisplayAdapter;
import com.example.shoppingapp.Adapter.WillBuyAdapter;
import com.example.shoppingapp.Models.Items;
import com.example.shoppingapp.NavigationActivity;
import com.example.shoppingapp.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    HomePageDisplayAdapter adapter;
    WillBuyAdapter willBuyAdapter;
    String toastText = "Clicked";
    List<Items> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        list = new ArrayList<>();
        list.add(new Items("Lemon Tea", 12.99f, 1, "Good day time", true));
        list.add(new Items("Green Tea", 11.99f, 1, "Happy Hour", false));
        list.add(new Items("Grass Tea", 10.99f, 1, "Good day time", false));
        list.add(new Items("Black Tea", 5.09f, 1, "Good day time", false));
        list.add(new Items("Bubble Tea", 10.99f, 1, "Good day time", false));
        list.add(new Items("Bubble Tea", 10.99f, 1, "Good day time", false));

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new HomePageDisplayAdapter(getContext(), list);
        adapter.notifyDataSetChanged();
        binding.recyclerView.setAdapter(adapter);

        binding.buyList.setHasFixedSize(true);
        binding.buyList.setLayoutManager(new LinearLayoutManager(getContext()));
        willBuyAdapter = new WillBuyAdapter(getContext(), list);
        adapter.notifyDataSetChanged();
        binding.buyList.setAdapter(willBuyAdapter);

        binding.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NavigationActivity.class);
                startActivity(intent);
            }
        });

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ArrayList<Items> newList = new ArrayList<>();
                if (Objects.equals(tab.getText(), "Recommended")) {
                    newList.addAll(list);
                } else if (Objects.equals(tab.getText(), "Black Tea")) {
                    for (Items i : list)
                        if (i.getName().equals("Black Tea"))
                            newList.add(i);
                } else if (Objects.equals(tab.getText(), "Green Tea")) {
                    for (Items i : list)
                        if (i.getName().equals("Green Tea"))
                            newList.add(i);
                }
                if (Objects.equals(tab.getText(), "Recommended")) {
                    ArrayList<Items> all = new ArrayList<>(list);
                    adapter = new HomePageDisplayAdapter(getContext(), all);
                } else if (Objects.equals(tab.getText(), "Black Tea")) {
                    ArrayList<Items> blackTea = new ArrayList<>();
                    for (Items i : list)
                        if (i.getName().equals("Black Tea"))
                            blackTea.add(i);
                    adapter = new HomePageDisplayAdapter(getContext(), blackTea);
                } else if (Objects.equals(tab.getText(), "Green Tea")) {
                    ArrayList<Items> greenTea = new ArrayList<>();
                    for (Items i : list)
                        if (i.getName().equals("Green Tea"))
                            greenTea.add(i);
                    adapter = new HomePageDisplayAdapter(getContext(), greenTea);
                }
                adapter.notifyDataSetChanged();
                binding.recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                binding.recyclerView.setAdapter(adapter);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return binding.getRoot();
    }
}