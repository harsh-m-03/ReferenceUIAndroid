package com.example.shoppingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.ItemDetailsActivity;
import com.example.shoppingapp.Models.Items;
import com.example.shoppingapp.R;

import java.util.List;

public class HomePageDisplayAdapter extends RecyclerView.Adapter<HomePageDisplayAdapter.ViewHolder> {
    public static List<Items> list;
    Context context;

    public HomePageDisplayAdapter(Context context, List<Items> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomePageDisplayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_home_page_items, parent, false);

        return new HomePageDisplayAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageDisplayAdapter.ViewHolder holder, int position) {
        Items item = list.get(position);

        holder.itemName.setText(item.getName());

        if (item.getBookmark()) holder.bookmark.setVisibility(View.VISIBLE);
        else holder.bookmark.setVisibility(View.INVISIBLE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetailsActivity.class);
                intent.putExtra("ItemName", item.getName());
                intent.putExtra("ItemNote", item.getNote());
                intent.putExtra("Price", String.valueOf(item.getPrice()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        ImageView bookmark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookmark = itemView.findViewById(R.id.bookmark);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }
}
