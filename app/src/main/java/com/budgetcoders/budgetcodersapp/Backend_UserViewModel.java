package com.budgetcoders.budgetcodersapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

// File used to provide a way of viewing a table with database values if needed

public class Backend_UserViewModel extends AndroidViewModel {
    private Backend_UserRepository userRepository;

    private LiveData<List<Backend_UserProfile>> allProfiles;
    private Backend_UserProfile[] allProfilesArr;

    public Backend_UserViewModel(Application application) {
        super(application);
        userRepository = new Backend_UserRepository(application);
        allProfiles = userRepository.getAllUsers();

    }

    LiveData<List<Backend_UserProfile>> getAllProfiles() {
        return allProfiles;
    }

    Backend_UserProfile[] loadMatchingInfo() {
        return allProfilesArr;
    }

    public void insert(Backend_UserProfile userProfile) {
        userRepository.insert(userProfile);
    }


}