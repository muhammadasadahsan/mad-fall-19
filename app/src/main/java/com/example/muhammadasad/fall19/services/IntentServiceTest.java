package com.example.muhammadasad.fall19.services;

import android.app.IntentService;
import android.content.Intent;
import androidx.annotation.Nullable;
import android.util.Log;

import static android.content.ContentValues.TAG;


public class IntentServiceTest extends IntentService {

    public IntentServiceTest(){
        super("Intent Service");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int maxCount = intent.getIntExtra("maxCountValue", -1);
        /**
         * Suppose we want to print 1 to 1000 number with one-second interval, Each task will take time 1 sec, So here now sleeping thread for one second.
         */
        for (int i = 0; i < maxCount; i++) {
            Log.d(TAG, "onHandleWork: The number is: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
