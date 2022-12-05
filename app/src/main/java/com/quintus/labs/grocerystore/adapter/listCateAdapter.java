package com.quintus.labs.grocerystore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.quintus.labs.grocerystore.R;
import com.quintus.labs.grocerystore.model.listCate;

import java.util.List;

public class listCateAdapter extends  RecyclerView.Adapter<listCateAdapter.MyViewHolder> {
    private List<listCate>  arrayCate;
    private Context context;

    public listCateAdapter(List<listCate> arrayCate) {
        this.arrayCate = arrayCate;
    }


    public listCateAdapter(Context context, List<listCate> arrayCate) {
        this.context = context;
        this.arrayCate = arrayCate;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item, parent , false);
        return new MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        listCate i = arrayCate.get(position);
        holder.textView.setText(i.getCategoryName());
    }

    @Override
    public int getItemCount() {
        return arrayCate.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.catetext);
            cardView = itemView.findViewById(R.id.cateItem);
        }
    }
}
