package com.budgetcoders.budgetcodersapp;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.ref.WeakReference;

public class Account_Creation extends AppCompatActivity {

    // Declare variables
    private Button createAccount;
    private EditText Password;
    private EditText ConfirmPassword;
    private EditText Email;
    private EditText FirstName;
    private EditText LastName;

    //Backend_UsersDatabase db;
    // Used to access the database of users
    Backend_UsersDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account__creation);

        // gets info from the user database
        db = Backend_UsersDatabase.getDatabase(this);

        // assign the values of UI elements
        FirstName = (EditText)findViewById(R.id.FName);
        LastName = (EditText)findViewById(R.id.LName);
        Password = (EditText)findViewById(R.id.PW);
        ConfirmPassword = (EditText)findViewById(R.id.ConfirmPW);
        Email = (EditText)findViewById(R.id.Email);

        createAccount = findViewById(R.id.CreateAccount);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String FirstNamestring = FirstName.getText().toString();
                String LastNamestring = LastName.getText().toString();
                String Passwordstring = Password.getText().toString();
                String ConfirmPasswordstring = ConfirmPassword.getText().toString();
                String Emailstring = Email.getText().toString();

                //stores the user's information into the database when passwords match
                if (ConfirmPasswordstring.equals(Passwordstring))
                {
                    final Backend_UserProfile me = new Backend_UserProfile(FirstNamestring, LastNamestring, Emailstring, Passwordstring);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            db.Backend_UserDAO().insert(me);
                        }
                    }) .start();

                    finish();
                }
                //Show a banner at the bottom of the page when passwords not matched
                else
                {
                    Snackbar.make(view, R.string.snack_bar,Snackbar.LENGTH_LONG)
                            .show();
                }

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