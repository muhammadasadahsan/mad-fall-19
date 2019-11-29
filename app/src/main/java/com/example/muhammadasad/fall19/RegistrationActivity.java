package com.example.muhammadasad.fall19;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.muhammadasad.fall19.recycler.RecyclerViewActivity;

public class RegistrationActivity extends AppCompatActivity {

    EditText firstname;
    EditText lastname;
    EditText password;
    EditText email;
    EditText phone;
    EditText confirmpassword;
    EditText confirmemail;
    EditText postalAdress;
    EditText gender;
    CheckBox cb;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firstname = findViewById(R.id.firstName);
        lastname = findViewById(R.id.lastName);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmPassword);
        email = findViewById(R.id.email);
        confirmemail = findViewById(R.id.confirmEmail);
        phone = findViewById(R.id.phoneNumber);
        postalAdress = findViewById(R.id.address);

        cb = findViewById(R.id.termsandconditions);
        submit = findViewById(R.id.submitbutton);
    }

    public void OnSubmit (View v){
        String fname = firstname.getText().toString();
        String lname = lastname.getText().toString();
        String pass = password.getText().toString();
        String emailtxt = email.getText().toString();
        String phonetxt = phone.getText().toString();

        boolean isError= false;
        if(fname != null && fname.equalsIgnoreCase("")){
            firstname.setError("Please enter Valid First name");
            isError = true;
        }
        if(lname != null && lname.equalsIgnoreCase("")){
            lastname.setError("Please enter Valid Last name");
            isError = true;
        }
        if(pass != null && pass.equalsIgnoreCase("")){
            password.setError("Please enter Valid name");
            isError = true;
        }
        if(emailtxt != null && emailtxt.equalsIgnoreCase("")){
            email.setError("Please enter Valid name");
            isError = true;
        }
        if(phonetxt != null && phonetxt.equalsIgnoreCase("")){
            phone.setError("Please enter Valid name");
            isError = true;
        }
        if(!cb.isChecked()){
            cb.setTextColor(Color.RED);
            isError = true;
        }

        if(!isError){
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);

        }

    }
}
