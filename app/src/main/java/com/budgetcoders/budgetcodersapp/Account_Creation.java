package com.budgetcoders.budgetcodersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Account_Creation extends AppCompatActivity {

    private Button createAccount;
    private EditText Password;
    private EditText Email;
    private EditText FirstName;
    private EditText LastName;

    Backend_UsersDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account__creation);

        db = Backend_UsersDatabase.getDatabase(this);

        FirstName = (EditText)findViewById(R.id.FName);
        LastName = (EditText)findViewById(R.id.LName);
        Password = (EditText)findViewById(R.id.PW);
        Email = (EditText)findViewById(R.id.Email);

        createAccount = findViewById(R.id.CreateAccount);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String FirstNamestring = FirstName.getText().toString();
                String LastNamestring = LastName.getText().toString();
                String Passwordstring = Password.getText().toString();
                String Emailstring = Email.getText().toString();

                Backend_UserProfile me = new Backend_UserProfile(FirstNamestring, LastNamestring, Emailstring, Passwordstring);

                db.Backend_UserDAO().insert(me);


                finish();
            }
        });
    }


    /*
        private void createAnAccount() {

            Intent intent = new Intent(this, Login_Screen.class);
            startActivity(intent);
        }
    */

    }

