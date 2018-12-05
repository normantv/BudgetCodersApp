package com.budgetcoders.budgetcodersapp;

public class Goals {

    // Goal Name
    void setGoalName(String name) {
        goalName = name;
    }

    String getGoalName() {
        return goalName;
    }

    // Balance Goal
    void setBalanceGoal(int goal) {
        balanceGoal = goal;
    }

    int getBalanceGoal() {
        return balanceGoal;
    }

    // Variable Declarations
    private String goalName;
    private int balanceGoal;
}