package com.budgetcoders.budgetcodersapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class UserProfile {

    // Personal Information

        // First Name
            void setFirstName(String str) {
                firstName = str;
            }

            String getFirstName() {
                return firstName;
            }

        // Middle Name (should be optional)
            void setMiddleName(String str) {
                    middleName = str;
                }

            String getMiddleName() {
                if (!middleName.equals("")) {
                    return middleName;
                }
                else {
                    System.out.println("No Middle Name");
                    return "";
                }
            }

        // Last Name
            void setLastName(String str) {
                lastName = str;
            }

            String getLastName() {
                return lastName;
            }

    // Birthday

        // Birthday Day
            void setBirthDay(int num) {
                if (num <= 31 && num >= 1) {
                    birthDay = num;
                }
                else {
                    System.out.println("Please enter valid day.");
                }
            }

            int getBirthDay() {
                return birthDay;
            }

        // Birthday Month
            void setBirthMonth(int num) {
                if (num <= 12 && num >= 1) {
                    birthMonth = num;
                }
                else {
                    System.out.println("Please enter valid month.");
                }
            }

            int getBirthMonth() {
                return birthMonth;
            }

        //Birthday Year
            void setBirthYear(int num) {
                Calendar cal = Calendar.getInstance();
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);

                if (num <= currentYear) {
                    birthYear = num;
                }
                else {
                    System.out.println("Please enter valid year.");
                }
            }

            int getBirthYear() {
                return birthYear;
            }


    // Current Age
    /*
    int (Date birthDate, Date currentDate) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(birthDate));
        int d2 = Integer.parseInt(formatter.format(currentDate));
        int age = (d2 - d1) / 10000;
        return age;
    }
    */

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

            String getEmail() {
                return email;
            }

        // Password
            void setPasswordTryA(String str) {
                passwordTryA = str;
            }

            void setPasswordTryB(String str) {
                passwordTryB = str;
            }

            private boolean checkPassword() {
                return passwordTryA.equals(passwordTryB);
            }

            void setPassword() {
                if (checkPassword()) {
                    password = passwordTryA;
                }
                else {
                    System.out.println("Passwords do not match");
                }
            }

    private String firstName;
    private String middleName;
    private String lastName;

    private int birthDay;
    private int birthMonth;
    private int birthYear;

    private String email;
    private String password;
    private String passwordTryA;
    private String passwordTryB;
}
