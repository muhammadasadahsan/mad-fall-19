package com.example.muhammadasad.fall19.services;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.muhammadasad.fall19.R;

public class ServiceActivity extends AppCompatActivity {


    BoundedService myService;
    private ServiceConnection serviceConnection;
    boolean isBound = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        serviceConnection = new ServiceConnection(){
            @Override
            public void onServiceConnected(ComponentName name, IBinder service){
                BoundedService.BinderClass binder = (BoundedService.BinderClass) service;
                myService = binder.getBoundedService();
                isBound = true;
                int a =myService.startLoop(100);
                Log.d("Service Output", a +"::");
            }
            @Override
            public void onServiceDisconnected(ComponentName name){
                isBound = false;
            }
        };

    }


    public void startForeGroundService(View v) {
        Intent serviceIntent = new Intent(this, ForeGroundService.class);
        serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android");
        ContextCompat.startForegroundService(this, serviceIntent);
    }
    public void stopForeGroundService(View v) {
        Intent serviceIntent = new Intent(this, ForeGroundService.class);
        stopService(serviceIntent);
    }

    public void startJobService(View v){
        Intent mIntent = new Intent(this, JobIntentServiceTest.class);
        mIntent.putExtra("maxCountValue", 1000);
        JobIntentServiceTest.enqueueWork(this, mIntent);
    }

    public void onIntentServiceStart(View v){
        Intent mIntent = new Intent(this, IntentServiceTest.class);
        mIntent.putExtra("maxCountValue", 100);
        startService(mIntent);
    }

    public void onBoundedIntentService(View v){
        Intent intent = new Intent(this, BoundedService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }


}
