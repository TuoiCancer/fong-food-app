package com.quintus.labs.grocerystore.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.quintus.labs.grocerystore.R;
import com.quintus.labs.grocerystore.activity.BaseActivity;
import com.quintus.labs.grocerystore.activity.MainActivity;
import com.quintus.labs.grocerystore.activity.ProductViewActivity;
import com.quintus.labs.grocerystore.interfaces.AddorRemoveCallbacks;
import com.quintus.labs.grocerystore.model.Cart;
import com.quintus.labs.grocerystore.model.myModel.MyProduct;
import com.quintus.labs.grocerystore.util.Utils;
import com.quintus.labs.grocerystore.util.localstorage.LocalStorage;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.quintus.labs.grocerystore.activity.BaseActivity.TAG;

public class NewProductAdapter extends RecyclerView.Adapter<NewProductAdapter.MyViewHolder> {

    List<MyProduct> myProductList;
    Context context;
    String Tag;

    LocalStorage localStorage;
    Gson gson;
    List<Cart> cartList = new ArrayList<>();
    String _quantity, _price, _attribute, _subtotal;

    public NewProductAdapter(List<MyProduct> myProductList, Context context) {
        this.myProductList = myProductList;
        this.context = context;
    }

    public NewProductAdapter(List<MyProduct> myProductList, Context context, String tag) {
        this.myProductList = myProductList;
        this.context = context;
        Tag = tag;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView;
        if (Tag.equalsIgnoreCase("Home")) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_new_home_products, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_new_products, parent, false);
        }

        return new MyViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        final MyProduct myProduct = myProductList.get(position);
        localStorage = new LocalStorage(context);
        gson = new Gson();
        cartList = ((BaseActivity) context).getCartList();
        holder.quantity.setText("1");

        holder.title.setText(myProduct.getName());
        if (myProduct.getDiscount() != null && myProduct.getDiscount().length() != 0) {
            holder.price.setText(myProduct.getDiscount());
            holder.org_price.setText(myProduct.getPrice());
            holder.org_price.setPaintFlags(holder.org_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        } else {
            holder.price.setText(myProduct.getPrice());
            holder.org_price.setVisibility(View.GONE);
        }
        holder.currency.setText(myProduct.getCurrency());
        holder.attribute.setText(myProduct.getAttribute());
        Log.d(TAG, Utils.ProductImage + myProduct.getImgProduct());
        Picasso.get().load( myProduct.getImgProduct()).error(R.drawable.no_image).into(holder.imageView, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                Log.d("Error : ", e.getMessage());
            }
        });

        if (!cartList.isEmpty()) {
            for (int i = 0; i < cartList.size(); i++) {
                if (cartList.get(i).getId().equalsIgnoreCase(String.valueOf(myProduct.getId()))) {
                    holder.shopNow.setVisibility(View.GONE);
                    holder.quantity_ll.setVisibility(View.VISIBLE);
                    holder.quantity.setText(cartList.get(i).getQuantity());

                }
            }
        }


        holder.shopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.shopNow.setVisibility(View.GONE);
                holder.quantity_ll.setVisibility(View.VISIBLE);
                if (myProduct.getDiscount() != null && myProduct.getDiscount().length() != 0) {
                    _price = myProduct.getDiscount();
                } else {
                    _price = myProduct.getPrice();
                }
                _quantity = holder.quantity.getText().toString();
                _attribute = myProduct.getAttribute();
                _subtotal = String.valueOf(Double.parseDouble(_price) * Integer.parseInt(_quantity));

                if (context instanceof MainActivity) {
                    Cart cart = new Cart(String.valueOf(myProduct.getId()), myProduct.getName(), myProduct.getImgProduct(), myProduct.getCurrency(), _price, _attribute, _quantity, _subtotal);
                    cartList = ((BaseActivity) context).getCartList();
                    cartList.add(cart);

                    String cartStr = gson.toJson(cartList);
                    //Log.d("CART", cartStr);
                    localStorage.setCart(cartStr);
                    ((AddorRemoveCallbacks) context).onAddProduct();
                    notifyItemChanged(position);
                }
            }
        });


        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < cartList.size(); i++) {
                    if (cartList.get(i).getId().equalsIgnoreCase(String.valueOf(myProduct.getId()))) {
                        int total_item = Integer.parseInt(cartList.get(i).getQuantity());
                        total_item++;
                        Log.d("totalItem", total_item + "");
                        holder.quantity.setText(total_item + "");
                        _subtotal = String.valueOf(Double.parseDouble(holder.price.getText().toString()) * total_item);
                        cartList.get(i).setQuantity(holder.quantity.getText().toString());
                        cartList.get(i).setSubTotal(_subtotal);
                        String cartStr = gson.toJson(cartList);
                        //Log.d("CART", cartStr);
                        localStorage.setCart(cartStr);
                    }
                }


            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Integer.parseInt(holder.quantity.getText().toString()) != 1) {
                    for (int i = 0; i < cartList.size(); i++) {
                        if (cartList.get(i).getId().equalsIgnoreCase(String.valueOf(myProduct.getId()))) {
                            int total_item = Integer.parseInt(holder.quantity.getText().toString());

                            total_item--;
                            holder.quantity.setText(total_item + "");
                            Log.d("totalItem", total_item + "");

                            _subtotal = String.valueOf(Double.parseDouble(holder.price.getText().toString()) * total_item);

                            cartList.get(i).setQuantity(holder.quantity.getText().toString());
                            cartList.get(i).setSubTotal(_subtotal);
                            String cartStr = gson.toJson(cartList);
                            //Log.d("CART", cartStr);
                            localStorage.setCart(cartStr);

                        }
                    }

                }


            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
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
        TextView title, attribute, currency, price, org_price, shopNow;
        ProgressBar progressBar;
        LinearLayout quantity_ll;
        TextView plus, minus, quantity;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.product_image);
            title = itemView.findViewById(R.id.product_title);
            attribute = itemView.findViewById(R.id.product_attribute);
            price = itemView.findViewById(R.id.product_price);
            org_price = itemView.findViewById(R.id.original_price);
            currency = itemView.findViewById(R.id.product_currency);
            shopNow = itemView.findViewById(R.id.shop_now);
            progressBar = itemView.findViewById(R.id.progressbar);
            quantity_ll = itemView.findViewById(R.id.quantity_ll);
            quantity = itemView.findViewById(R.id.quantity);
            plus = itemView.findViewById(R.id.quantity_plus);
            minus = itemView.findViewById(R.id.quantity_minus);
            cardView = itemView.findViewById(R.id.card_view);

        }
    }
}
