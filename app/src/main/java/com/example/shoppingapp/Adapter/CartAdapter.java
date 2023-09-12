package com.example.shoppingapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.ItemDetailsActivity;
import com.example.shoppingapp.Models.Items;
import com.example.shoppingapp.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    Context context;
    List<Items> list;

    public CartAdapter(Context context, List<Items> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_my_cart, parent, false);

        return new CartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Items item = list.get(position);
        holder.itemName.setText(item.getName());
        holder.price.setText(String.valueOf(item.getPrice()));

        int[] quantity = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            quantity[i] = 1;
        }

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.quantity.setText(String.valueOf(++quantity[position]));
                list.get(position).setQuantity(quantity[position]);
            }
        });
        holder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (--quantity[position] >= 0)
                    holder.quantity.setText(String.valueOf(quantity[position]));
                else {
                    item.setQuantity(0);
                    quantity[position]=0;
                }
                list.get(position).setQuantity(quantity[position]);
            }
        });

        holder.itemName.setOnClickListener(new View.OnClickListener() {
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
        TextView price;
        TextView quantity;
        Button add, sub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
            add = itemView.findViewById(R.id.add);
            sub = itemView.findViewById(R.id.subtract);
        }
    }
}
