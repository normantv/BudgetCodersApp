/*
/ EC327 Final Project
/ Milestones Backend for BudgetCoders App
/ Created by Norman A. Toro on December 2nd, 2018
*/

// Version 0.0.1

#include <jni.h>
#include<iostream>
#include<string>

using namespace std;

extern "C"

class goal {
    public:
        // Goal Name
            void setGoalName(string name) {
                goalName = name;
            }

            string getGoalName() {
                return goalName;
            }
        
        // Balance Goal
            void setBalanceGoal(int goal) {
                balanceGoal = goal;
            }

            int getBalanceGoal() {
                return balanceGoal;
            }

    private:
    string goalName;
    int balanceGoal;
};

void apple() {
    cout << "Hello!" << endl;
}