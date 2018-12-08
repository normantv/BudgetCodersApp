package com.budgetcoders.budgetcodersapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class Backend_UserRepository {
    private Backend_UserDAO userDAO;
    private LiveData<List<Backend_UserProfile>> allUsers;

    Backend_UserRepository(Application application) {
        Backend_UsersDatabase db = Backend_UsersDatabase.getDatabase(application);
        userDAO = db.Backend_UserDAO();
        allUsers = userDAO.getAllUsers();
    }

    LiveData<List<Backend_UserProfile>> getAllUsers() {
        return allUsers;
    }

    public void insert(Backend_UserProfile userProfile) {
        new insertAsyncTask(userDAO).execute(userProfile);
    }

    private static class insertAsyncTask extends AsyncTask<Backend_UserProfile, Void, Void> {
        private Backend_UserDAO mAsyncTaskDAO;

        insertAsyncTask(Backend_UserDAO dao) {
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Backend_UserProfile... params) {
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
