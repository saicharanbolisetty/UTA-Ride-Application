package com.android.venkatsaicharan.sestarteasy;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by venkatsaicharan on 11/26/2016.
 */

public class UpdateRequestForm extends StringRequest {


    private static final String REGISTER_REQUEST_URL = "http://omega.uta.edu/~axs8103/updateform.php";
    private Map<String, String> params;

    public UpdateRequestForm(String email, Response.Listener<String> listener) {
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);

    }

    @Override
    public Map<String, String> getParams() {
        // params.put("Content-Type", "application/json; charset=utf-8");
        return params;
    }
}
