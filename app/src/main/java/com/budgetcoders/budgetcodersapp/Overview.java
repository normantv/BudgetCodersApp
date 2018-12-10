package com.budgetcoders.budgetcodersapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Overview extends AppCompatActivity {

    private Button editAccount1;
    private Button editAccount2;
    private Button editAccount3;

    private TextView account1TextView;
    private TextView account1TextView2;
    private TextView account2TextView;
    private TextView account2TextView2;
    private TextView account3TextView;
    private TextView account3TextView2;

    private TextView amount1TextView;
    private TextView amount2TextView;
    private TextView amount3TextView;

    private TextView totalAmount;

    private Button TEMPORARYBUTTON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        editAccount1 = (Button)findViewById(R.id.button3);
        editAccount2 = (Button)findViewById(R.id.button5);
        editAccount3 = (Button)findViewById(R.id.button6);

        account1TextView = (TextView)findViewById(R.id.account1TextView);
        account1TextView2 = (TextView)findViewById(R.id.account1TextView2);
        account2TextView = (TextView)findViewById(R.id.account2TextView);
        account2TextView2 = (TextView)findViewById(R.id.account2TextView2);
        account3TextView = (TextView)findViewById(R.id.account3TextView);
        account3TextView2 = (TextView)findViewById(R.id.account2TextView3);

        amount1TextView = (TextView)findViewById(R.id.amount1TextView);
        amount2TextView = (TextView)findViewById(R.id.amount2TextView);
        amount3TextView = (TextView)findViewById(R.id.amount3TextView);

        final Backend_BankAccount vacationFund = new Backend_BankAccount("Bank of America", "Vacation Fund", 0);
        final Backend_BankAccount savings = new Backend_BankAccount("Banco Popular de Puerto Rico", "Savings", 0);
        final Backend_BankAccount christmasFund = new Backend_BankAccount("Bank of America", "Christmas Fund", 0);

        account1TextView.setText(vacationFund.getAccountName());
        account2TextView.setText(savings.getAccountName());
        account3TextView.setText(christmasFund.getAccountName());

        account1TextView2.setText(vacationFund.getBankName());
        account2TextView2.setText(savings.getBankName());
        account3TextView2.setText(christmasFund.getBankName());

        amount1TextView.setText("$" + Integer.toString(vacationFund.getBalance()));
        amount2TextView.setText("$" + Integer.toString(savings.getBalance()));
        amount3TextView.setText("$" + Integer.toString(christmasFund.getBalance()));

        totalAmount = (TextView)findViewById(R.id.textView14);
        totalAmount.setText("$" + Integer.toString(vacationFund.getBalance() + savings.getBalance() + christmasFund.getBalance()));

        editAccount1 = (Button)findViewById(R.id.button3);
        editAccount2 = (Button)findViewById(R.id.button5);
        editAccount3 = (Button)findViewById(R.id.button6);

        TEMPORARYBUTTON = (Button)findViewById(R.id.button8);


        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        editAccount1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alerty = alert.create();

                alerty.setTitle("Change Account Balance");
                alerty.setMessage("Please enter the new balance.");

                if(input.getParent()!=null)
                    ((ViewGroup)input.getParent()).removeView(input); // <- fix

                alerty.show();

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        vacationFund.setBalance(Integer.parseInt(input.getText().toString()));
                        String balance1 = Integer.toString(vacationFund.getBalance());
                        amount1TextView.setText("$" + balance1);

                        int balance1int = vacationFund.getBalance();
                        int balance2int = savings.getBalance();
                        int balance3int = christmasFund.getBalance();

                        totalAmount.setText("$" + Integer.toString(balance1int + balance2int + balance3int));
                    }
                });
            }
        });

        editAccount2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alerty = alert.create();

                alerty.setTitle("Change Account Balance");
                alerty.setMessage("Please enter the new balance.");

                if(input.getParent()!=null)
                    ((ViewGroup)input.getParent()).removeView(input); // <- fix

                alerty.show();

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        savings.setBalance(Integer.parseInt(input.getText().toString()));
                        String balance2 = Integer.toString(savings.getBalance());
                        amount2TextView.setText("$" + balance2);

                        int balance1int = vacationFund.getBalance();
                        int balance2int = savings.getBalance();
                        int balance3int = christmasFund.getBalance();

                        totalAmount.setText("$" + Integer.toString(balance1int + balance2int + balance3int));
                    }
                });
            }
        });


        editAccount3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alerty = alert.create();

                alerty.setTitle("Change Account Balance");
                alerty.setMessage("Please enter the new balance.");

                if(input.getParent()!=null)
                    ((ViewGroup)input.getParent()).removeView(input); // <- fix

                alerty.show();

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        christmasFund.setBalance(Integer.parseInt(input.getText().toString()));
                        String balance3 = Integer.toString(christmasFund.getBalance());
                        amount3TextView.setText("$" + balance3);

                        int balance1int = vacationFund.getBalance();
                        int balance2int = savings.getBalance();
                        int balance3int = christmasFund.getBalance();

                        totalAmount.setText("$" + Integer.toString(balance1int + balance2int + balance3int));
                    }
                });
            }
        });

        TEMPORARYBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalAmountSavedString = totalAmount.getText().toString().replace("$", "");
                final int totalAmountSaved = Integer.parseInt(totalAmountSavedString);
                Intent intent = new Intent(Overview.this, Goal_Creation.class);
                intent.putExtra("totalAmount", totalAmountSaved);
                startActivity(intent);
            }
        });

    }









}
