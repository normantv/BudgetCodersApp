package com.budgetcoders.budgetcodersapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "user_table")
public class Backend_UserProfile {

    @PrimaryKey
    @NonNull
    private String password;

    private String email;

    private String firstName;

    private String lastName;

    // All at once
    public Backend_UserProfile(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Personal Information

        // First Name
            void setFirstName(String str) {
                firstName = str;
            }

            public String getFirstName() {
                return firstName;
            }

        // Last Name
            void setLastName(String str) {
                lastName = str;
            }

            public String getLastName() {
                return lastName;
            }

    // Account Information
        // Email
            void setEmail(String str) {
                if (str.contains("@")) {
                    email = str;
                }
                else {
                    System.out.println("Please enter a valid email.");
                }
            }

            public String getEmail() {
                return email;
            }

        // Password

            void setPassword(String password) {
                this.password = password;
            }

            public String getPassword() {
                return password;
            }


}
