package com.example.insorma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class ProductInsormaAdapter extends RecyclerView.Adapter<ProductInsormaAdapter.ProductViewHolderInsorma>{

    private ArrayList<ProductInsorma> productInsorma;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;
    ProductInsormaAdapter(Context context, ArrayList<ProductInsorma> produkInsorma){
        this.layoutInflater = LayoutInflater.from(context);
        this.productInsorma = produkInsorma;
    }

    @Override
    public ProductViewHolderInsorma onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_product_insorma_,parent,false);
        return new ProductViewHolderInsorma(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolderInsorma holder, int position) {
        int imageProduct = productInsorma.get(position).image;
        String productName = productInsorma.get(position).productName;
        Float ratingProduct = productInsorma.get(position).rating;
        Integer priceProduct = productInsorma.get(position).price;
        holder.imageProduct.setImageResource(imageProduct);
        holder.nameProduct.setText(productName);
        holder.ratingProduct.setText(ratingProduct.toString());
        holder.priceProduct.setText(priceProduct.toString());
    }

    @Override
    public int getItemCount() {
        return  productInsorma.size();
    }

    ProductInsorma getItem(int id){
        return  productInsorma.get(id);
    }
    void setClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


    public class ProductViewHolderInsorma extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageProduct;
        TextView nameProduct, ratingProduct, priceProduct;
        public ProductViewHolderInsorma(View itemView) {
            super(itemView);
            imageProduct = itemView.findViewById(R.id.iViewProduct);
            nameProduct = itemView.findViewById(R.id.tvNameProduct);
            ratingProduct = itemView.findViewById(R.id.tvRatingProduct);
            priceProduct = itemView.findViewById(R.id.tvPriceProduct);
            itemView.setOnClickListener(this);

        }
        public void onClick(View view){
            if(itemClickListener != null)
                itemClickListener.onItemClick(view,getAdapterPosition());
        }
    }
}
