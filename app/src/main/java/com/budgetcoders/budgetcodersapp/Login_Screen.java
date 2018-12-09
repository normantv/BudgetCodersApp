package com.budgetcoders.budgetcodersapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
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
    private Backend_UserViewModel userViewModel;



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

        // USERVIEWMODEL
        userViewModel = ViewModelProviders.of(this).get(Backend_UserViewModel.class);

       // userViewModel.getAllProfiles().observe(this, new Observer<List<Backend_UserProfile>>() {
       //     @Override
       //     public void onChanged(@Nullable final List<Backend_UserProfile> words) {
       //     }
       // });

        final String usernameString = Username.getText().toString();


        //Backend_UsersDatabase db;
        //db = Room.databaseBuilder(getApplicationContext().getApplicationContext(), Backend_UsersDatabase.class)
        //db = Backend_UsersDatabase.getDatabase(this);
        //Backend_UserProfile[] loginArray = db.Backend_UserDAO().loadMatchingInfo(usernameString);
        //final String password1 = loginArray[0].toString();


        final String password1 = "Hello";

        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(usernameString, Password.getText().toString(), password1);
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

    private void validate(String userName, String userPassword, String test){

        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(Login_Screen.this, Menu.class);
            startActivity(intent);
        }else{
            counter--;
            //Info.setText("Number of Attempts Remaining: " + String.valueOf(counter));
            Info.setText(test);
            if(counter == 0){
                toMenu.setEnabled(false);
            }
        }
    }
}
