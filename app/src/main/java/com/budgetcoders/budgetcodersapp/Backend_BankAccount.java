package com.budgetcoders.budgetcodersapp;

public class BankAccount {

    // Bank Name
        void setBankName(String bank) {
            bankName = bank;
        }

        String getBankName() {
            return bankName;
        }

    // Specific Account Name
        void setAccountName(String name) {
            accountName = name;
        }

        String getAccountName() {
            return accountName;
        }

    // Account Balance
        void setBalance(int remainingBalance) {
            balance = remainingBalance;
        }

        void addBalance(int additionalBalance) {
            balance = balance + additionalBalance;
        }

        int getBalance() {
            return balance;
        }


    private String bankName;
    private String accountName;

    private String username;
    private String password;

    private int balance;

}