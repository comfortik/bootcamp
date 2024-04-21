package com.example.myapplication.api.room;

import retrofit2.Call;

import com.example.myapplication.domain.Room;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RoomAPI {

    @GET("/room/users/{id}")
    Call<Room> getRoom(@Path("id") long id);
}
