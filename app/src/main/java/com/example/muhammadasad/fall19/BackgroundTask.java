package com.example.muhammadasad.fall19;

import android.os.AsyncTask;
import android.util.Log;

public class BackgroundTask extends AsyncTask<String,Integer,Integer> {
    @Override
    protected Integer doInBackground(String... strings) {
        Log.e("BackgroundTask", "doInBackground");
        for(int i= 0 ; i< 100000; i++){
            if(i == 10000){
                publishProgress(1);
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        Log.e("BackgroundTask", "onPreExecute");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        Log.e("BackgroundTask", "onPostExecute");
        super.onPostExecute(integer);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.e("BackgroundTask", "onProgressUpdate");
        super.onProgressUpdate(values);
    }
}
