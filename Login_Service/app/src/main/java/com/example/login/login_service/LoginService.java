package com.example.login.login_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class LoginService extends Service {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String YEAR_OF_BIRTH = "year_of_birth";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand (Intent intent, int flags, int startid){
        Log.d(MainActivity.TAG, "Initializing the service");

        String username = intent.getStringExtra(USERNAME);
        String password = intent.getStringExtra(PASSWORD);
        String yearOfbirthString= intent.getStringExtra(YEAR_OF_BIRTH);

        int yearOfBirth = 0;

        if (null != yearOfbirthString) {
            yearOfBirth = Integer.parseInt(yearOfbirthString);
        }

        String age = String.valueOf(age(yearOfBirth));

        if (username.equals("service") && password.equals("service")) {
            Toast.makeText(this.getApplicationContext(), "Logged in and you are " + age + " years old", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this.getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
            stopSelf();
        }

        Log.d(MainActivity.TAG, "Username : " + username);
        Log.d(MainActivity.TAG, "Password : " + password);
        Log.d(MainActivity.TAG, "Year of birth :" + yearOfBirth);

        return START_STICKY;
    }

    public int age(int yearOfBirth) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        if (yearOfBirth >= currentYear) {
            return 0;
        }

        return currentYear - yearOfBirth;
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.TAG, "Service destroyed");
    }
}
