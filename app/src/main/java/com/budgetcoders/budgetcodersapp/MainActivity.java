package com.budgetcoders.budgetcodersapp;

import android.arch.lifecycle.ViewModelProvider;
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

        ToLogin = findViewById(R.id.button);

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








