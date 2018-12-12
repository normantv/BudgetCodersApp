package com.budgetcoders.budgetcodersapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

// File used to create database

@Database(entities = {Backend_UserProfile.class}, version = 1, exportSchema = false)
public abstract class Backend_UsersDatabase extends RoomDatabase {

    public abstract Backend_UserDAO Backend_UserDAO();

    private static volatile Backend_UsersDatabase INSTANCE;

    // Abstraction layer of Database
    static Backend_UsersDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            // create database here
            synchronized (Backend_UsersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Backend_UsersDatabase.class, "user_database").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
