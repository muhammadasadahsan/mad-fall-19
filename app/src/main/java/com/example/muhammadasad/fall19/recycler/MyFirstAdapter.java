package com.example.muhammadasad.fall19.recycler;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.muhammadasad.fall19.Main2Activity;
import com.example.muhammadasad.fall19.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyFirstAdapter extends RecyclerView.Adapter<MyFirstAdapter.DataViewHolder> {

    ArrayList<DataItem> datalist;
    public MyFirstAdapter(ArrayList<DataItem> dt){
        datalist = dt;

    }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View dv =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlayout,viewGroup,false);
        return new DataViewHolder(dv);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int i) {

        dataViewHolder.tv.setText(datalist.get(i).getName());
        dataViewHolder.tv2.setText(datalist.get(i).getPhonenumber());

    }



    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        TextView tv2;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView2);
            tv2 = itemView.findViewById(R.id.textView3);
        }
    }
}
