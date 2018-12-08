package com.budgetcoders.budgetcodersapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.lang.reflect.Array;
import java.util.List;

@Dao
public interface Backend_GoalsDAO {

    @Insert
    void insert(Backend_Goals goal);

    @Query("SELECT * FROM goals_table")
    LiveData<List<Backend_Goals>> getAllGoals();


}
