package com.android.venkatsaicharan.sestarteasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    String cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Intent intent = getIntent();
        cost=intent.getStringExtra("cost");
    }

    public void paypalpaymentClicked(View view){

        Intent i = new Intent(Payment.this, PaypalPayment.class);
        i.putExtra("cost",cost);
        startActivity(i);

    }


    public void androidpaymentClicked(View view){

        Intent i = new Intent(Payment.this, AndroidPayment.class);
        i.putExtra("cost",cost);
        startActivity(i);

    }

    public void cashClicked(View view)
    {
        Toast.makeText(getApplicationContext(),"Cash Payment Selected",Toast.LENGTH_LONG).show();
    }



}
