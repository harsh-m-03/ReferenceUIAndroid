package com.example.shoppingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.ItemDetailsActivity;
import com.example.shoppingapp.Models.Items;
import com.example.shoppingapp.R;

import java.util.List;

public class WillBuyAdapter extends RecyclerView.Adapter<WillBuyAdapter.ViewHolder> {
    Context context;
    List<Items> list;

    public WillBuyAdapter(Context context, List<Items> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_will_buy, parent, false);

        return new WillBuyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Items items = list.get(position);

        holder.itemName.setText(items.getName());
        holder.itemNote.setText(items.getNote());
        holder.price.setText(String.valueOf(items.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetailsActivity.class);
                intent.putExtra("ItemName", items.getName());
                intent.putExtra("ItemNote", items.getNote());
                intent.putExtra("Price", String.valueOf(items.getPrice()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName, price, itemNote;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.price);
            itemNote = itemView.findViewById(R.id.item_note);
        }
    }
}
