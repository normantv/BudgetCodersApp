package com.budgetcoders.budgetcodersapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

// This file is part of the required files to make Android Room Databases work correctly

public class Backend_UserRepository {
    // Declare variables
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


    // wrapper method for executing insert UserProfile in the background
    public void insert(Backend_UserProfile userProfile) {
        new insertAsyncTask(userDAO).execute(userProfile);
    }

    // Allows tasks to be done in the background and not make the UI hang
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
