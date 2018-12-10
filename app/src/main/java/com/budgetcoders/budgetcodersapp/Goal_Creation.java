package com.budgetcoders.budgetcodersapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Goal_Creation extends AppCompatActivity {
    private Button createGoal;
    private EditText goalName;
    private EditText balanceGoal;
    private Button updateProgress;
    private TextView totalAmount;
    private TextView nextGoal;
    private TextView nextGoalAmount;
    private TextView remainingToNext;

    //Backend_UsersDatabase db;
    Backend_GoalsRoomDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_creation);

        Intent intent = getIntent();
        final int intValue = intent.getIntExtra("totalAmount", 0);

        db = Backend_GoalsRoomDatabase.getDatabase(this);

        goalName = (EditText)findViewById(R.id.goalname);
        balanceGoal = (EditText)findViewById(R.id.balancegoal);

        createGoal = findViewById(R.id.creategoal);

        updateProgress = (Button)findViewById(R.id.button7);

        nextGoal = (TextView)findViewById(R.id.textView12);
        nextGoal.setText("");

        nextGoalAmount = (TextView)findViewById(R.id.textView13);
        nextGoalAmount.setText("");


        remainingToNext = (TextView)findViewById(R.id.textView15);

        createGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String GoalNamestring = goalName.getText().toString();
                String BalanceGoalstring = balanceGoal.getText().toString();
                int BalanceGoalint = Integer.parseInt(BalanceGoalstring);


                final Backend_Goals latest = new Backend_Goals(GoalNamestring, BalanceGoalint);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        db.backend_goalsDAO().insert(latest);
                    }
                }) .start();

                finish();
            }
        });

        updateProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backend_Goals[] goalList = db.backend_goalsDAO().getAllGoalsArr();

                int minNum = goalList[0].getBalanceGoal();
                int minObjectIndex = 0;

                if (goalList.length != 0) {
                    for (int i = 0; i < goalList.length; i++) {
                        if (goalList[i].getBalanceGoal() < minNum && goalList[i].getBalanceGoal() > intValue) {
                            minNum = goalList[i].getBalanceGoal();
                            minObjectIndex = i;
                        }
                    }

                }


                int currentGoalInt = goalList[minObjectIndex].getBalanceGoal();
                String currentGoalName = goalList[minObjectIndex].getGoalName();

                int remainingToNextGoal = currentGoalInt - intValue;

                remainingToNext.setText(Integer.toString(remainingToNextGoal));

                nextGoal.setText(currentGoalName);
                nextGoalAmount.setText("$" + Integer.toString(currentGoalInt));



            }
        });

    }}