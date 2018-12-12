package com.budgetcoders.budgetcodersapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

// This file is part of the required files to make Android Room Databases work correctly

public class Backend_GoalsRepository {
    // Declare variables
    private Backend_GoalsDAO goalsDAO;
    private LiveData<List<Backend_Goals>> allGoals;

    Backend_GoalsRepository(Application application) {
        Backend_GoalsRoomDatabase db = Backend_GoalsRoomDatabase.getDatabase(application);
        goalsDAO = db.backend_goalsDAO();
        allGoals = goalsDAO.getAllGoals();

    }

    LiveData<List<Backend_Goals>> getAllGoals() {
        return allGoals;
    }

    // wrapper method for executing insert Goal in the background
    public void insert(Backend_Goals goal) {
        new insertAsyncTask(goalsDAO).execute(goal);
    }

    // Allows tasks to be done in the background and not make the UI hang
    private static class insertAsyncTask extends AsyncTask<Backend_Goals, Void, Void> {

        private Backend_GoalsDAO mAsyncTaskDao;

        insertAsyncTask(Backend_GoalsDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Backend_Goals... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
