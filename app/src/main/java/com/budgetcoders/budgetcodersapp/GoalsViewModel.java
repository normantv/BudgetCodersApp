package com.budgetcoders.budgetcodersapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class GoalsViewModel extends AndroidViewModel {
    private Backend_GoalsRepository goalsRepository;
    private LiveData<List<Backend_Goals>> allGoals;

    public GoalsViewModel(Application application) {
        super(application);
        goalsRepository = new Backend_GoalsRepository(application);
        allGoals = goalsRepository.getAllGoals();
    }

    LiveData<List<Backend_Goals>> getAllGoals() {
        return allGoals;
    }

    public void insert(Backend_Goals goal) {
        goalsRepository.insert(goal);
    }
}
