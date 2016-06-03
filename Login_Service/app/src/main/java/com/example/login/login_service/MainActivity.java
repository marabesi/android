package com.example.login.login_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "LOGIN_SERVICE";

    private EditText username;
    private EditText password;
    private DatePicker dateOfbrith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        dateOfbrith = (DatePicker) findViewById(R.id.date_of_birth);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        dateOfbrith.updateDate(year, month, day);
    }

    public void doLogin(View view) {
        Intent loginService = new Intent(this, LoginService.class);

        loginService.putExtra(LoginService.USERNAME, username.getText().toString());
        loginService.putExtra(LoginService.PASSWORD, password.getText().toString());

        String year = String.valueOf(dateOfbrith.getYear());

        loginService.putExtra(LoginService.YEAR_OF_BIRTH, year);

        startService(loginService);
    }
}
