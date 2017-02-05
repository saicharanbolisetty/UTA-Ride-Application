package com.android.venkatsaicharan.sestarteasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidPayment extends AppCompatActivity {

    String cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_payment);


        Intent intent = getIntent();
        cost=intent.getStringExtra("cost");

        TextView price=(TextView)findViewById(R.id.androidcost);
        price.setText(cost);
    }



    public void androidClicked(View view){


        Toast.makeText(getApplicationContext(),"Payment Successful",Toast.LENGTH_LONG).show();

        //Intent i = new Intent(Payment.this, PaypalPayment.class);
        // startActivity(i);

    }

}
