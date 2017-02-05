package com.android.venkatsaicharan.sestarteasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Cancel extends AppCompatActivity {

    String ride,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);

        Intent intent = getIntent();
        email=intent.getStringExtra("email");

        final CheckBox checkBox = (CheckBox) findViewById(R.id.formcheck);
        if (checkBox.isChecked()) {
            ride="No";
        }
        else
            ride="Yes";

    }

    public void cancel1Clicked(View view)
    {
        Intent i = new Intent(Cancel.this, UserScreen.class);
        i.putExtra("ride",ride);
        i.putExtra("email",email);
        startActivity(i);
        Toast.makeText(getApplicationContext(),"Cancel Successful",Toast.LENGTH_LONG).show();


    }
}
