package com.example.muhammadasad.fall19.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import static android.support.constraint.Constraints.TAG;

public class BoundedService extends Service {

    private final IBinder binder = new BinderClass();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public int startLoop(int maxCount){
        return maxCount * 10;
    }

    public class BinderClass extends Binder{
        BoundedService getBoundedService(){
            return BoundedService.this;
        }
    }
}
