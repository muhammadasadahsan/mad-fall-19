package com.example.muhammadasad.fall19;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText username;
    EditText password;
    EditText email;
    EditText phone;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        email = findViewById(R.id.editText3);
        phone = findViewById(R.id.editText4);
        cb = findViewById(R.id.checkBox);
    }

    public void onClickSubmitButton(View v){
        String name = username.getText().toString();
        String pass = password.getText().toString();
        String emailtxt = email.getText().toString();
        String phonetxt = phone.getText().toString();
        boolean isError= false;
        if(name != null && name.equalsIgnoreCase("")){
            username.setError("Please enter Valid name");
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
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("NAME", name);
            startActivity(intent);

        }

    }

    private boolean userNameValidation(String str){
        boolean isValid = false;

        if(!str.contains("@"))
            isValid = true;
        if(str.length() < 5)
            isValid = false;
        return isValid;
    }

}
