package com.android.venkatsaicharan.sestarteasy;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ForgotPassword extends AppCompatActivity {


    private EditText fpEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        fpEmail=(EditText)findViewById(R.id.fpEmail);
    }

    public void forgotpasswordClicked(View view){
        final String femail = fpEmail.getText().toString();




        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {


                        String email = jsonResponse.getString("email");
                        String password = jsonResponse.getString("password");

                        new SendMailTask(ForgotPassword.this).execute("sestarteasy@gmail.com",
                                "Hello2016", email, email, password);
                        // Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();

                       // Intent intent = new Intent(LoginActivity.this, UserScreen.class);

                        //intent.putExtra("email", femail);
                       // LoginActivity.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this);
                        builder.setMessage("Login Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RequestForgot forgotRequest = new RequestForgot(femail, responseListener);
        RequestQueue queue = Volley.newRequestQueue(ForgotPassword.this);
        queue.add(forgotRequest);





    }


}
