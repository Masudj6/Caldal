package com.sk.chaldal.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.sk.chaldal.R;

public class ProductDetails extends AppCompatActivity {
    private TextView pName,tvoPrice,tvcPrice,tv_details;
    private ImageView iv_productImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        String name = getIntent().getStringExtra("name");
        String des = getIntent().getStringExtra("des");
        String cPrice = getIntent().getStringExtra("cPrice");
        String oPrice=getIntent().getStringExtra("oPrice");

        int image = Integer.valueOf(getIntent().getStringExtra("image"));

        initView(name,cPrice,oPrice,image,des);
    }



    private void initView(String name,String cPrice,String oPrice,int image,String detales ) {
        pName = (TextView) findViewById(R.id.pName);
        pName.setText(name);
        tvoPrice= (TextView) findViewById(R.id.tv_oPrice);
        tvoPrice.setText(oPrice);
        tvcPrice= (TextView) findViewById(R.id.tv_cPrice);
        tvcPrice.setText(cPrice);
        tv_details= (TextView) findViewById(R.id.tv_details);
        tv_details.setText(detales);


        iv_productImage= (ImageView) findViewById(R.id.i);
        iv_productImage.setImageResource(image);

    }
}
