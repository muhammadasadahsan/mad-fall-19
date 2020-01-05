package com.example.muhammadasad.fall19;

import android.content.Intent;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.muhammadasad.fall19.db.DBOperations;
import com.example.muhammadasad.fall19.db.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
    String fname="";
    String lname ="" ;
    String pass = "";
    String emailtxt ="";
    String phonetxt = "";
    String gendertxt= "";
    String address = "";
    FirebaseAuth firebaseAuth;

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
        gender = findViewById(R.id.gender);
        cb = findViewById(R.id.termsandconditions);
        submit = findViewById(R.id.submitbutton);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void OnSubmit (View v){
         fname = firstname.getText().toString();
         lname = lastname.getText().toString();
         pass = password.getText().toString();
         emailtxt = email.getText().toString();
         phonetxt = phone.getText().toString();
         gendertxt = gender.getText().toString();
        address = postalAdress.getText().toString();

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
        if(gendertxt != null && gendertxt.equalsIgnoreCase("")){
            gender.setError("Please enter Valid name");
            isError = true;
        }
        if(!cb.isChecked()){
            cb.setTextColor(Color.RED);
            isError = true;
        }

        if(!isError){
//            if(saveUser() != 0) {
//                Intent intent = new Intent(this, MainActivity.class);
//                startActivity(intent);
//            } else{
//                Toast.makeText(this,"Some thing went wrong",Toast.LENGTH_LONG).show();
//            }
            firebaseAuth.createUserWithEmailAndPassword(emailtxt, pass).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {

                    if (!task.isSuccessful()) {
                        Toast.makeText(RegistrationActivity.this.getApplicationContext(),
                                "SignUp unsuccessful: " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();

                    } else {
                        FirebaseUser fbuser = firebaseAuth.getCurrentUser();
                        Log.d("User:::" , fbuser.getEmail());
                        startActivity(new Intent(RegistrationActivity.this, Main2Activity.class));
                    }
                }

            });

        }

    }

    private  User getUser(){
        User user = new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setAddress(address);
        user.setEmail(emailtxt);
        user.setGender(gendertxt);
        user.setPhoneNumber(phonetxt);
        user.setPassword(pass);
        return user;
    }

    private long saveUser(){
        DBOperations db = new DBOperations();
        return  db.writeUserinDB(getUser());
    }

}
