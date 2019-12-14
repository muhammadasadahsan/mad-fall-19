package com.example.muhammadasad.fall19.networking;

import com.example.muhammadasad.fall19.db.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyService {
    @GET("posts")
    Call<List<Post>> getmyData();
//    Call<Post> getmyData(@Query("email") String email);

    @GET("getuser")
    Call<UserResponse> getmyLocalData(@Query("email") String email);
}
