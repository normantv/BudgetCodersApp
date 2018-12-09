package com.budgetcoders.budgetcodersapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Goal_Creation extends AppCompatActivity {
    private Button createGoal;
    private EditText goalName;
    private EditText balanceGoal;

    //Backend_UsersDatabase db;
    Backend_UsersDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_creation);

        db = Backend_UsersDatabase.getDatabase(this);

        goalName = (EditText)findViewById(R.id.goalname);
        balanceGoal = (EditText)findViewById(R.id.balancegoal);

        createGoal = findViewById(R.id.creategoal);

        createGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String GoalNamestring = goalName.getText().toString();
                String BalanceGoalstring = balanceGoal.getText().toString();
                int BalanceGoalint = Integer.parseInt(BalanceGoalstring);


                final Backend_Goals me = new Backend_Goals(GoalNamestring, BalanceGoalint);


            }
        });
    }}