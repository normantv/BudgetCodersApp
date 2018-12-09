package com.budgetcoders.budgetcodersapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Backend_Goals.class}, version = 1, exportSchema = false)
public abstract class Backend_GoalsRoomDatabase extends RoomDatabase {
    public abstract Backend_GoalsDAO backend_goalsDAO();

    private static volatile Backend_GoalsRoomDatabase INSTANCE;

    static Backend_GoalsRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Backend_GoalsRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Backend_GoalsRoomDatabase.class, "goals_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
