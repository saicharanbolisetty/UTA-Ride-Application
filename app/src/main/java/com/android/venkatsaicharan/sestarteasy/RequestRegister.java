package com.android.venkatsaicharan.sestarteasy;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by venkatsaicharan on 11/18/2016.
 */

public class RequestRegister extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://omega.uta.edu/~axs8103/Register.php";
    private Map<String, String> params;

    public RequestRegister(String email, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        params.put("Content-Type", "application/json; charset=utf-8");
        return params;
    }
}