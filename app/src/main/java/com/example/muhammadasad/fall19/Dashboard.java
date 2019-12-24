package com.example.muhammadasad.fall19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.muhammadasad.fall19.services.ServiceActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class Dashboard extends AppCompatActivity {

    Button signIn;
    Button singUp;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        signIn = findViewById(R.id.signin);
        singUp = findViewById(R.id.signup);
        img = findViewById(R.id.imageView);


    }

    public void signInClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    public void signUpClick(View v){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void showImage(View v) {
       loadImage();
    }

    private void loadImage(){
        Picasso.get().load("https://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png").into(img, new Callback() {
            @Override
            public void onSuccess() {
                Log.e("TAG", "Sucesss");
            }

            @Override
            public void onError(Exception e) {
                Log.e("TAG", "Faliure");
            }
        });
    }

    public void onStartService(View v){
        Intent intent = new Intent(this, ServiceActivity.class);
        startActivity(intent);

    }
}
