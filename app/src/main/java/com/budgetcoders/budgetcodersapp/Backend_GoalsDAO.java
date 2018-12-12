package com.budgetcoders.budgetcodersapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import java.lang.reflect.Array;
import java.util.List;

@Dao
public interface Backend_GoalsDAO {

    // Inserts a Goal Object into the Goals database
    @Insert
    void insert(Backend_Goals goal);

    // Queries all Goals in the database and stores them into a LiveData List
    @Query("SELECT * FROM goals_table")
    LiveData<List<Backend_Goals>> getAllGoals();

    // Queries all Goals in the database and stores them into a Goals Array
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT * FROM goals_table")
    Backend_Goals[] getAllGoalsArr();


}
