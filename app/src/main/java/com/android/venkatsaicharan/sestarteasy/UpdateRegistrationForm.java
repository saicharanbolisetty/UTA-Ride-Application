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

public class UpdateRegistrationForm extends AppCompatActivity {

    private EditText name,contact,doa,toa,address,passport;
    String iemail,sim,carrier,ride;
    String usim,ucarrier,uride,upassport,uaddress,uname,udoa,utoa,ucontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_registration_form);


        Intent intent = getIntent();
        iemail= intent.getStringExtra("iemail");
        uname= intent.getStringExtra("name");
        ucontact= intent.getStringExtra("contact");
        udoa= intent.getStringExtra("doa");
        utoa= intent.getStringExtra("toa");
        uaddress= intent.getStringExtra("address");
        usim= intent.getStringExtra("sim");
        ucarrier= intent.getStringExtra("carrier");
        uride= intent.getStringExtra("ride");
        upassport= intent.getStringExtra("passport");

        name=(EditText)findViewById(R.id.mformName);
        name.setText(uname);
        contact=(EditText)findViewById(R.id.mformNumber);
        contact.setText(ucontact);
        doa=(EditText)findViewById(R.id.mformdoa);
        doa.setText(udoa);
        toa=(EditText)findViewById(R.id.mformtoa);
        toa.setText(utoa);
        address=(EditText)findViewById(R.id.mformAddress);
        address.setText(uaddress);
        passport=(EditText)findViewById(R.id.mpassportNumber);
        passport.setText(upassport);

        RadioButton simyes=(RadioButton) findViewById(R.id.msimYes);
        RadioButton simno=(RadioButton) findViewById(R.id.msimNo);
        RadioButton carrierlyca=(RadioButton) findViewById(R.id.mcarrierLyca);
        RadioButton carriertmobile=(RadioButton) findViewById(R.id.mcarrierTmobile);
        RadioButton rideind=(RadioButton) findViewById(R.id.mrideInd);
        RadioButton rideshared=(RadioButton) findViewById(R.id.mrideShared);

        if(usim.equals("Yes")) {
            simyes.setChecked(true);
            simyes.performClick();
        }
        else {
            simno.setChecked(true);
            simno.performClick();
        }

        if(ucarrier.equals("Lyca")) {
            carrierlyca.setChecked(true);
            carrierlyca.performClick();
        }
        else {
            carriertmobile.setChecked(true);
            carriertmobile.performClick();
        }

        if(uride.equals("individual")) {
            rideind.setChecked(true);
            rideind.performClick();
        }
        else {
            rideshared.setChecked(true);
            rideshared.performClick();
        }






    }


    public void mformregisterClicked(View view){


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

                        Toast.makeText(getApplicationContext(),"Update Successful",Toast.LENGTH_LONG).show();

                        // Intent intent = new Intent(LoginActivity.this, UserScreen.class);

                        // intent.putExtra("email", mEmail);
                        //  LoginActivity.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(UpdateRegistrationForm.this);
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
        RequestQueue queue = Volley.newRequestQueue(UpdateRegistrationForm.this);
        queue.add(formRequest);


    }


    public void monsimClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.msimYes:
                if (checked)
                    sim = "Yes";
                break;
            case R.id.msimNo:
                if (checked)
                    sim = "No";
                break;
        }
    }

    public void moncarrierClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.mcarrierLyca:
                if (checked)
                    carrier="Lyca";
                break;
            case R.id.mcarrierTmobile:
                if (checked)
                    carrier="Tmobile";
                break;
        }
    }

    public void monrideClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.mrideShared:
                if (checked)
                    ride="shared";
                break;
            case R.id.mrideInd:
                if (checked)
                    ride="individual";
                break;
        }
    }



}
