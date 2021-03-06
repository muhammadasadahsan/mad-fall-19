package com.example.muhammadasad.fall19.recycler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muhammadasad.fall19.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rcv;
    MyFirstAdapter adp;
    ArrayList<DataItem> dt = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rcv = findViewById(R.id.recyclerView);
        setListInItem();
        adp = new MyFirstAdapter(dt);
        rcv.setAdapter(adp);
        rcv.setLayoutManager(new LinearLayoutManager(this));

    }

    private  void setListInItem(){
        for(int i = 0 ; i< 15; i++){
            dt.add(new DataItem("Name" + i,"1234566"+i));

        }
    }
}
