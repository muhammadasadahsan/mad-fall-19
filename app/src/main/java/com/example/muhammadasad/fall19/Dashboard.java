package com.example.muhammadasad.fall19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button signIn;
    Button singUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        signIn = findViewById(R.id.signin);
        singUp = findViewById(R.id.signup);


    }

    public void signInClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    public void signUpClick(View v){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

}
