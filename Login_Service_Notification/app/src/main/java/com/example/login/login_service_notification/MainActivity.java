package com.example.login.login_service_notification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private DatePicker dateOfBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        dateOfBirth = (DatePicker) findViewById(R.id.datePicker);
    }

    public void doLogin(View view) {
        Intent login = new Intent(this, LoginService.class);
        login.putExtra("email", email.getText().toString());
        login.putExtra("password", password.getText().toString());
        login.putExtra("dateOfBirth", dateOfBirth.toString());
    }
}
