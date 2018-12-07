package com.budgetcoders.budgetcodersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class Account_Creation extends AppCompatActivity {
    private Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account__creation);

        createAccount = findViewById(R.id.button3);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

