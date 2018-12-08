package com.budgetcoders.budgetcodersapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface Backend_UserDAO {

    @Insert
    void insert(Backend_UserProfile profile);

    @Query("Select * FROM user_table")
    LiveData<List<Backend_UserProfile>> getAllUsers();
}