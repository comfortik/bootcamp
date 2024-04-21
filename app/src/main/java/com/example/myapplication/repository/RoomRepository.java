package com.example.myapplication.repository;

import com.example.myapplication.api.room.RoomAPIService;
import com.example.myapplication.domain.Room;

import retrofit2.Call;

public class RoomRepository {

    public static Call<Room> getRoom(long id) {
        return RoomAPIService.getInstance().getRoom(id);
    }
}
