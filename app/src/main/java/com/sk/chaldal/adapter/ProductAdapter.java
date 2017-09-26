package com.sk.chaldal.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sk.chaldal.R;
import com.sk.chaldal.activity.ProductDetails;
import com.sk.chaldal.model.Product;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by masud on 9/22/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private ArrayList<Product> productArrayList;
    private Context context;

    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
        this.context = context;
        Log.e(TAG, "ProductAdapter: ");
    }


    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listrow_products, parent, false);
        ProductAdapter.MyViewHolder holder = new MyViewHolder(view);
        Log.e(TAG, "onCreateViewHolder: ");
        return holder;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.MyViewHolder holder, int position) {
        holder.tv_productName.setText(productArrayList.get(position).getName());
        holder.tv_productQuantity.setText(productArrayList.get(position).getQuantiy());
        holder.tv_productPrice.setText(productArrayList.get(position).getPrices());
        holder.iv_productImage.setImageResource(productArrayList.get(position).getImage());
        Log.e(TAG, "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {
        return this.productArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv_productName;
        private TextView tv_productPrice;
        private TextView tv_productPrice2;



        private TextView tv_productQuantity;
        private TextView tv_productCounter;

        private ImageView iv_productImage;
        private ImageView iv_counterAdd;
        private ImageView iv_counterSub;


        private MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            tv_productName = itemView.findViewById(R.id.tv_productName);
            tv_productPrice = itemView.findViewById(R.id.tv_productPrice);
         //   tv_productPrice2 = itemView.findViewById(R.id.tv_productPrice2);
            tv_productPrice2=itemView.findViewById(R.id.tv_productPrice2);
            tv_productQuantity = itemView.findViewById(R.id.tv_productQuantity);
            tv_productCounter = itemView.findViewById(R.id.tv_productCounter);

            iv_productImage = itemView.findViewById(R.id.iv_productImage);
            iv_counterAdd = itemView.findViewById(R.id.iv_counterAdd);
            iv_counterSub = itemView.findViewById(R.id.iv_counterSub);


            Log.e(TAG, "MyViewHolder: ");

        }

        @Override
        public void onClick(View view) {

            Toast.makeText(context, "text", Toast.LENGTH_SHORT).show();
//            Log.e(TAG, "onClickFrom_ProductAdapter: "+getAdapterPosition() );
            Intent i = new Intent(context, ProductDetails.class);
            i.putExtra("details", productArrayList.get(getAdapterPosition()).getName());
            i.putExtra("price", productArrayList.get(getAdapterPosition()).getPrices());
            i.putExtra("image",String.valueOf(productArrayList.get(getAdapterPosition()).getImage()));
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.getApplicationContext().startActivity(i);
           // tv_productPrice2.setPaintFlags( tv_productPrice2.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        }

    }

}

