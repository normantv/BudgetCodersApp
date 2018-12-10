package com.budgetcoders.budgetcodersapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Login_Screen extends AppCompatActivity {
    private Button toAccountCreate;
    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button toMenu;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);

        // Declare vars
        Username = (EditText)findViewById(R.id.editText);
        Password = (EditText)findViewById(R.id.editText2);
        Info = (TextView)findViewById(R.id.textView9);
        toMenu = (Button)findViewById(R.id.button4);

        Info.setText("Number of Attempts Remaining: 5");

        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });

        toAccountCreate = findViewById(R.id.button2);



        toAccountCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                goToAccountCreate();
            }
        });

    }



    private void goToAccountCreate() {

        Intent intent2 = new Intent(this, Account_Creation.class);
        startActivity(intent2);
    }

    private void validate(String userName, String userPassword){

        Backend_UsersDatabase db;
        db = Backend_UsersDatabase.getDatabase(this);
        Backend_UserProfile[] loginArray = db.Backend_UserDAO().loadMatchingInfo();

        for (int i = 0; i < loginArray.length; i++) {
            if (loginArray[i].getEmail().equals(userName)) {
                if (loginArray[i].getPassword().equals(userPassword)) {
                    Intent intent = new Intent(Login_Screen.this, Overview.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                counter--;
                Info.setText("Number of Attempts Remaining: " + String.valueOf(counter));
                if(counter == 0){
                    toMenu.setEnabled(false);
                }
            }
        };
        handler.postDelayed(r, 2000);
        }

    }

