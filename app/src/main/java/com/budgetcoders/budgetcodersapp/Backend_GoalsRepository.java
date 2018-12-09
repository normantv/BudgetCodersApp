package com.budgetcoders.budgetcodersapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class Backend_GoalsRepository {
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

    public void insert(Backend_Goals goal) {
        new insertAsyncTask(goalsDAO).execute(goal);
    }

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
