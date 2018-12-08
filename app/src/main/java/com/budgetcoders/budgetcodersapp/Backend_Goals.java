package com.budgetcoders.budgetcodersapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.net.URL;

@Entity(tableName = "goals_table")
public class Backend_Goals {


    // Variable Declarations
    @PrimaryKey
    @NonNull
    private String goalName;

    @NonNull
    private int balanceGoal;

    public Backend_Goals(String goalName, int balanceGoal) {
        this.goalName = goalName;
        this.balanceGoal = balanceGoal;
    }

    // Goal Name
    public void setGoalName(String name) {
        goalName = name;
    }

    public String getGoalName() {
        return goalName;
    }

    // Balance Goal
    public void setBalanceGoal(int goal) {
        balanceGoal = goal;
    }

    public int getBalanceGoal() {
        return balanceGoal;
    }


}