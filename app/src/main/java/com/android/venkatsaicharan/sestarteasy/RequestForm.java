package com.android.venkatsaicharan.sestarteasy;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by venkatsaicharan on 11/23/2016.
 */

public class RequestForm extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://omega.uta.edu/~axs8103/form1.php";
    private Map<String, String> params;

    public RequestForm(String email, String sname, String scontact, String sdoa, String stoa, String saddress,String sim,String carrier,String ride,String spassport, Response.Listener<String> listener) {
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("name", sname);
        params.put("contact", scontact + "");
        params.put("doa", sdoa );
        params.put("toa", stoa );
        params.put("address", saddress);
        params.put("sim", sim);
        params.put("carrier", carrier);
        params.put("ride", ride);
        params.put("passport", spassport);
    }

    @Override
    public Map<String, String> getParams() {
       // params.put("Content-Type", "application/json; charset=utf-8");
        return params;
    }

}
