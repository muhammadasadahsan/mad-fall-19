package com.example.muhammadasad.fall19;

import android.util.Log;
import android.widget.Toast;

import com.example.muhammadasad.fall19.db.User;
import com.example.muhammadasad.fall19.networking.MyService;
import com.example.muhammadasad.fall19.networking.Post;
import com.example.muhammadasad.fall19.networking.RetrofitClientInstance;
import com.example.muhammadasad.fall19.networking.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkManager {

    private static NetworkManager _instance = null;

    private  NetworkManager(){

    }

    public static NetworkManager getNetworkManger(){
        if(_instance == null){
            _instance = new NetworkManager();
        }
        return _instance;
    }

    public void getUserInformation(String email){
        MyService service = RetrofitClientInstance.getRetrofitInstance().create
                (MyService.class);
        Call<List<Post>> call = service.getmyData();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call,
                                   Response<List<Post>> response) {
                Log.e("My message" , "responese:::" + response.body().size());
                Toast.makeText(ApplicationContext.getAppContext(),"String found---"+response.body().size() ,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Post>>call, Throwable t) {
                Log.e("My message", ""+t.toString());
                Toast.makeText(ApplicationContext.getAppContext(),"String found---22222" ,Toast.LENGTH_LONG).show();
            }
        });

    }

    public void getLocalUserInformation(String email){
        MyService service = RetrofitClientInstance.getRetrofitInstance().create
                (MyService.class);
        Call<UserResponse> call = service.getmyLocalData(email);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call,
                                   Response<UserResponse> response) {
                Log.e("My message" , "responese:::" + response.body());
                Toast.makeText(ApplicationContext.getAppContext(),"String found---"+response.body() ,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UserResponse>call, Throwable t) {
                Log.e("My message", ""+t.toString());
                Toast.makeText(ApplicationContext.getAppContext(),"String found---22222" ,Toast.LENGTH_LONG).show();
            }
        });

    }
}
