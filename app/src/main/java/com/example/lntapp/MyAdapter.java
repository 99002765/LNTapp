package com.example.lntapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * MyAdapter is used to put data into each row of the listview.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.WordViewHolder> {
    String[] data;
    LayoutInflater layoutInflater;
    public MyAdapter(Context context,String[] languages) {
        this.data=languages;
        layoutInflater= LayoutInflater.from(context);
    }

    /**
     * 2. onCreateViewHolder is used to buy wooden planks
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = layoutInflater.inflate(R.layout.row_listview,parent,false);
        return new WordViewHolder(rowView);
    }

    /**
     * 3. onBindViewHolder is used to write data on the planks
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.WordViewHolder holder, int position) {
        holder.titleTextView.setText(data[position]);
    }

    /**
     * 1. getItemCount is used to keep the count of number of items in the dataset
     * @return
     */
    @Override
    public int getItemCount() {
        return data.length;
    }

    /**
     * WordViewHolder is used to hold the recycled stock and new stock of planks.
     */
    public class WordViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTextView;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.rowTextView);
        }
    }
}
