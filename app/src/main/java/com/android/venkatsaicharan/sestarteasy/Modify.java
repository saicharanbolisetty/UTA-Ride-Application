package com.android.venkatsaicharan.sestarteasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Modify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
    }


    public void modifyClicked(View view)
    {
        Toast.makeText(getApplicationContext(),"Modified",Toast.LENGTH_LONG).show();
    }
}
