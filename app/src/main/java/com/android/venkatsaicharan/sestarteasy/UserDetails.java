package com.android.venkatsaicharan.sestarteasy;

/**
 * Created by venkatsaicharan on 11/16/2016.
 */

public class UserDetails {

    private String _useremail;
    private String _userpassword;

    public UserDetails(){
    }

    public UserDetails(String useremail,String userpassword){
        this._useremail = useremail;
        this._userpassword = userpassword;
    }

    public void set_useremail(String _useremail) {
        this._useremail = _useremail;
    }

    public void set_productname(String _productname) {
        this._userpassword = _productname;
    }

    public String get_useremail() {
        return _useremail;
    }

    public String get_password() {
        return _userpassword;
    }



}
