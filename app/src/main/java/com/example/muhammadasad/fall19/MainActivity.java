package com.example.muhammadasad.fall19;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muhammadasad.fall19.db.DBOperations;
import com.example.muhammadasad.fall19.db.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText username;
    EditText password;
    EditText email;
    EditText phone;
    CheckBox cb;
    private ProgressBar spinner;

    FirebaseAuth firebaseAuth;

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
        spinner = findViewById(R.id.progressBar1);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onClickSubmitButton(View v){
        spinner.setVisibility(View.VISIBLE);
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
            firebaseAuth.signInWithEmailAndPassword(emailtxt, pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if (!task.isSuccessful()) {
                        spinner.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Not sucessfull", Toast.LENGTH_SHORT).show();
                    } else {
                        spinner.setVisibility(View.GONE);
                        startActivity(new Intent(MainActivity.this, Main2Activity.class));
                    }

                }
            });
       //            Intent intent = new Intent(this, RecyclerViewActivity.class);
//            intent.putExtra("NAME", name);
//            startActivity(intent);

        }
//        NetworkManager.getNetworkManger().getLocalUserInformation("asad@testuse");

//        executeTask();

    }

    private void executeTask(){
        new BackgroundTask().execute("test string");
    }

    private User getUser(String email){
        DBOperations db = new DBOperations();


         return db.getUserInformation(email);
    }
    private boolean userNameValidation(String str){
        SharedPreferences sp = getSharedPreferences("NAme", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("IsUserSave", "true");
        ed.commit();
        boolean isValid = false;

        if(!str.contains("@"))
            isValid = true;
        if(str.length() < 5)
            isValid = false;
        return isValid;
    }

}
