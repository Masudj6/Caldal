package com.sk.chaldal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.sk.chaldal.R;

public class ProductDetails extends AppCompatActivity {
    private TextView tv_productDetails;
    private ImageView iv_productImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        String data = getIntent().getStringExtra("details");
        String priceData = getIntent().getStringExtra("price");
        int image = Integer.valueOf(getIntent().getStringExtra("image"));

        initView(data + " and price is\n" + priceData,image);
    }

    private void initView(String data,int image) {
        tv_productDetails = (TextView) findViewById(R.id.tv_productDetails);
        tv_productDetails.setText(data);
        iv_productImage= (ImageView) findViewById(R.id.iv_productImage);
        iv_productImage.setImageResource(image);

    }
}
