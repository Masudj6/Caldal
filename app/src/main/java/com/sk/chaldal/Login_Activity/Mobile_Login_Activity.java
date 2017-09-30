package com.sk.chaldal.Login_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sk.chaldal.R;

public class Mobile_Login_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView mobile_phone, pin_in_sms, login_option;
    private EditText phone;
    private Button otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile__login_);

        ini();
    }


    private void ini() {
        mobile_phone= (TextView) findViewById(R.id.mobile_phone);
        pin_in_sms= (TextView) findViewById(R.id.pin_in_sms);
        login_option= (TextView) findViewById(R.id.login_option);
        phone= (EditText) findViewById(R.id.mobile_number);
        otp= (Button) findViewById(R.id.otp);

        otp.setOnClickListener(this);
        login_option.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_option:
            /** Start a new Activity MyCards.java */
            Intent intent = new Intent(this, Sign_Up.class);
            this.startActivity(intent);
            break;

        }

    }
}
