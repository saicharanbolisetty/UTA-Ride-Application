package com.android.venkatsaicharan.sestarteasy;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Cart extends AppCompatActivity {


    String ride1,email;
    TextView cartprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        ride1=intent.getStringExtra("ride");
        email=intent.getStringExtra("email");

        cartprice=(TextView) findViewById(R.id.cartPrice);
        if(ride1.equals("individual"))
            cartprice.setText("$35");
        else if(ride1.equals("shared"))
            cartprice.setText("$25");
        else
        cartprice.setText("$0");

    }


    public void proceedClicked(View view){

        Intent i = new Intent(Cart.this, Payment.class);
        String cost=cartprice.getText().toString();
        i.putExtra("cost",cost);
        startActivity(i);

    }


    public void cancelClicked(View view){

        Intent i = new Intent(Cart.this, Cancel.class);
        i.putExtra("email",email);
        startActivity(i);

    }

    public void modifyClicked(View view){



        final String memail = email;

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {

                        String name = jsonResponse.getString("name");
                        String contact = jsonResponse.getString("contact");
                        String doa = jsonResponse.getString("doa");
                        String toa = jsonResponse.getString("toa");
                        String address = jsonResponse.getString("address");
                        String sim = jsonResponse.getString("sim");
                        String carrier = jsonResponse.getString("carrier");
                        String ride = jsonResponse.getString("ride");
                        String passport = jsonResponse.getString("passport");



                        Intent i = new Intent(Cart.this, UpdateRegistrationForm.class);
                        i.putExtra("iemail",email);
                        i.putExtra("name",name);
                        i.putExtra("contact",contact);
                        i.putExtra("doa",doa);
                        i.putExtra("toa",toa);
                        i.putExtra("address",address);
                        i.putExtra("sim",sim);
                        i.putExtra("carrier",carrier);
                        i.putExtra("ride",ride);
                        i.putExtra("passport",passport);
                        startActivity(i);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Cart.this);
                        builder.setMessage("Update Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        UpdateRequestForm formRequest = new UpdateRequestForm(memail, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Cart.this);
        queue.add(formRequest);





    }


}
