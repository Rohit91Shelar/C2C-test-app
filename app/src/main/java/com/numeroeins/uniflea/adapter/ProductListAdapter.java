package com.numeroeins.uniflea.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.numeroeins.uniflea.Product;
import com.numeroeins.uniflea.R;

import java.util.ArrayList;

/**
 * Created by numeroeins on 10/11/17.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {


    private final Context context;
    private ArrayList<Product> productsList=new ArrayList<>();
    private boolean isFilled;

    public ProductListAdapter(Context context, ArrayList<Product> products) {
        this.context=context;
        this.productsList=products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_list_item_products,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Product product=productsList.get(position);
        holder.productPrice.setText(product.getProductPrice());
        holder.productName.setText(product.getProductName());
        holder.productImage.setImageResource(product.getProductImage());
        if (product.isLike())
            holder.imageButtonWishlist.setImageResource(R.drawable.ic_heart_filled);
        else
            holder.imageButtonWishlist.setImageResource(R.drawable.ic_heart_empty);

        holder.imageButtonWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (productsList.get(position).isLike()){
                    productsList.get(position).setLike(false);
                    Toast.makeText(context,"Removed from wishlist",Toast.LENGTH_SHORT).show();

                }else{
                    productsList.get(position).setLike(true);
                    Toast.makeText(context,"Added to wishlist",Toast.LENGTH_SHORT).show();
                }

                notifyDataSetChanged();

            }
        });


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView productImage;
        public TextView productName;
        public TextView productPrice;
        public ImageButton imageButtonWishlist;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.imageProduct);
            productName=itemView.findViewById(R.id.textProductName);
            productPrice=itemView.findViewById(R.id.textProductPrice);
            imageButtonWishlist=itemView.findViewById(R.id.imgButtonWishList);
        }
    }
}
