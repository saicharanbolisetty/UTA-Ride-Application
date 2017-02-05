package com.android.venkatsaicharan.sestarteasy;

/**
 * Created by venkatsaicharan on 11/16/2016.
 */

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static android.R.attr.name;


public class RegisterActivity extends AppCompatActivity {


    EditText registeremail,registerpassword,rconfirmpassword;
   // MyDBHandler dbHandler;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        registeremail = (EditText) findViewById(R.id.registerEmail);
        registerpassword = (EditText) findViewById(R.id.registerPassword);
        rconfirmpassword = (EditText) findViewById(R.id.rconfirmPassword);

       // dbHandler = new MyDBHandler(this, null, null, 1);
    }

    public void registerButtonClicked(View view){




        final String email = registeremail.getText().toString();

        final String password = registerpassword.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        RegisterActivity.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage("Register Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RequestRegister registerRequest = new RequestRegister(email, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
        queue.add(registerRequest);


    }


}
