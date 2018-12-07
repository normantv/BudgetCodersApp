package com.budgetcoders.budgetcodersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class Login_Screen extends AppCompatActivity {
    private Button toAccountCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);

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
}
