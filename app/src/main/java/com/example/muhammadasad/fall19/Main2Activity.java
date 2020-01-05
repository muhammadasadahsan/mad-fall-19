package com.example.muhammadasad.fall19;

import android.net.Uri;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements BlankFragment4.OnFragmentInteractionListener {

    TextView tv2;
    Button b1;
    Button b2;
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        tv2 = findViewById(R.id.textView2);
//        String greeding = getIntent().getStringExtra("NAME");
//        tv2.setText(greeding);
        b1 = findViewById(R.id.firstButton);
        b2 = findViewById(R.id.secondButton);
        b3 = findViewById(R.id.thirdButton);
    }

    public void myFirstButton(View v){
        BlankFragment bl = (BlankFragment) getSupportFragmentManager().findFragmentByTag("F1");
        if(bl != null){
            Toast.makeText(this,"Fragment is already hosted",Toast.LENGTH_LONG).show();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout2,new BlankFragment(),"F1");
        ft.commit();

    }
    public void mySecondButton(View v){
        BlankFragment2 bl = (BlankFragment2) getSupportFragmentManager().findFragmentByTag("F2");
        if(bl != null){
            Toast.makeText(this,"Fragment is already hosted",Toast.LENGTH_LONG).show();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout2,new BlankFragment2(),"F2");
        ft.commit();


    }
    public void myThirdButton(View v){



        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout2, BlankFragment4.newInstance("myFirstString","mySecondString"),"F3");

        ft.commit();

        BlankFragment4 bl = (BlankFragment4) getSupportFragmentManager().findFragmentByTag("F3");
        if(bl != null){
            bl.setmyString("Word 1" , "Word 2");
            Toast.makeText(this,bl.getString1(),Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
