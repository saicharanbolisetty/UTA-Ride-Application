package com.android.venkatsaicharan.sestarteasy;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by venkatsaicharan on 11/23/2016.
 */

public class RequestForgot extends StringRequest {


    private static final String LOGIN_REQUEST_URL = "http://omega.uta.edu/~axs8103/forgot.php";
    private Map<String, String> params;

    public RequestForgot(String email, Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
       // params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        params.put("Content-Type", "application/json; charset=utf-8");
        return params;
    }

}
