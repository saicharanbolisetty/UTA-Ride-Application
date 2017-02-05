package com.android.venkatsaicharan.sestarteasy;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationForm extends AppCompatActivity {

    private EditText name,contact,doa,toa,address,passport;
    String iemail;
    String sim,carrier,ride;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        name=(EditText)findViewById(R.id.mformName);
        contact=(EditText)findViewById(R.id.mformNumber);
        doa=(EditText)findViewById(R.id.mformdoa);
        toa=(EditText)findViewById(R.id.mformtoa);
        address=(EditText)findViewById(R.id.mformAddress);
        passport=(EditText)findViewById(R.id.mpassportNumber);

        Intent intent = getIntent();
        iemail= intent.getStringExtra("iemail");
    }

    public void formregisterClicked(View view){


        final String sname = name.getText().toString();
        final String scontact = contact.getText().toString();
        final String sdoa = doa.getText().toString();
        final String stoa = toa.getText().toString();
        final String saddress = address.getText().toString();
        final String spassport = passport.getText().toString();







        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {

                       Toast.makeText(getApplicationContext(),"Form Successful",Toast.LENGTH_LONG).show();

                       // Intent intent = new Intent(LoginActivity.this, UserScreen.class);

                       // intent.putExtra("email", mEmail);
                      //  LoginActivity.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationForm.this);
                        builder.setMessage("Form Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RequestForm formRequest = new RequestForm(iemail, sname, scontact, sdoa, stoa, saddress, sim, carrier,ride,spassport, responseListener);
        RequestQueue queue = Volley.newRequestQueue(RegistrationForm.this);
        queue.add(formRequest);


    }


    public void onsimClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.simYes:
                if (checked)
                    sim = "Yes";
                    break;
            case R.id.simNo:
                if (checked)
                    sim = "No";
                    break;
        }
    }

    public void oncarrierClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.carrierLyca:
                if (checked)
                    carrier="Lyca";
                    break;
            case R.id.carrierTmobile:
                if (checked)
                    carrier="Tmobile";
                    break;
        }
    }

    public void onrideClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rideShared:
                if (checked)
                    ride="shared";
                    break;
            case R.id.rideInd:
                if (checked)
                    ride="individual";
                    break;
        }
    }





}
