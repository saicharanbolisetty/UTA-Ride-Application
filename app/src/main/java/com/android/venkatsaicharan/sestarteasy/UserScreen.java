package com.android.venkatsaicharan.sestarteasy;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class UserScreen extends AppCompatActivity {

    public String email,ride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);


        final TextView useremail = (TextView) findViewById(R.id.usName);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        ride=intent.getStringExtra("ride");


        // Display user details
        String message = email + " welcome to Start Easy";
        useremail.setText(message);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id= item.getItemId();
        Intent intent = new Intent(UserScreen.this, Cart.class);
        intent.putExtra("ride",ride);
        intent.putExtra("email",email);

        UserScreen.this.startActivity(intent);


        return super.onOptionsItemSelected(item);
    }

    public void registrationformClicked(View view){

        Intent i = new Intent(UserScreen.this, RegistrationForm.class);
        i.putExtra("iemail",email);
        startActivity(i);

    }


    public void updateClicked(View view){

        Intent i = new Intent(UserScreen.this, Modify.class);
        //i.putExtra("email",email);
        startActivity(i);









    }


    public void logoutClicked(View view){

        Intent i = new Intent(UserScreen.this, LoginActivity.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(),"Logout Successful",Toast.LENGTH_LONG).show();
        finish();

    }



}
