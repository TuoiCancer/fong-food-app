package com.quintus.labs.grocerystore.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quintus.labs.grocerystore.R;
import com.quintus.labs.grocerystore.activity.ProductViewActivity;
import com.quintus.labs.grocerystore.model.myModel.MyProduct;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    List<MyProduct> myProductList;
    Context context;

    public SearchAdapter(List<MyProduct> myProductList, Context context) {
        this.myProductList = myProductList;
        this.context = context;
    }

    public SearchAdapter(List<MyProduct> myProductList, Context context, String tag) {
        this.myProductList = myProductList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_search_products, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        final MyProduct myProduct = myProductList.get(position);

        holder.title.setText(myProduct.getName());

        if (myProduct.getImgProduct() != "") {
            Picasso.get().load( myProduct.getImgProduct()).into(holder.imageView);
        }
        holder.row_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductViewActivity.class);
                intent.putExtra("id", myProduct.getId());
                intent.putExtra("title", myProduct.getName());
                intent.putExtra("image", myProduct.getImgProduct());
                intent.putExtra("price", myProduct.getPrice());
                intent.putExtra("currency", myProduct.getCurrency());
                intent.putExtra("attribute", myProduct.getAttribute());
                intent.putExtra("discount", myProduct.getDiscount());
                intent.putExtra("description", myProduct.getDescription());


                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return myProductList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        LinearLayout row_ll;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.search_image);
            title = itemView.findViewById(R.id.search_title);
            row_ll = itemView.findViewById(R.id.row_ll);
        }
    }
}
