package com.budgetcoders.budgetcodersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button ToLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToLogin = (Button) findViewById(R.id.button);

        ToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                goToLogin();
            }
        });

    }
    private void goToLogin() {

        Intent intent = new Intent(this, Login_Screen.class);
        startActivity(intent);
    }
}









/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declare the variables
    private Button CreateGoalButton;
    private EditText GoalNum;
    private TextView testview;

    static {
        System.loadLibrary("goals");
    }





    @Override
    // This happens when you create the android activity, (the current view)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking UI to functions (or Java functions until now)
        GoalNum = (EditText)findViewById(R.id.BudgetGoal);
        CreateGoalButton = (Button) findViewById(R.id.CreateGoalButton);
        testview = (TextView)findViewById(R.id.Test);

        CreateGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // converts what is stored in the number input GoalNum into a String
                String GoalNumString = GoalNum.getText().toString();

                // Sets the testview (the text) to what is Input in GoalNumString
                testview.setText(GoalNumString);
            }

        });



    }

}
*/

