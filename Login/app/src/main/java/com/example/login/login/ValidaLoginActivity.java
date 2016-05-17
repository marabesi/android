package com.example.login.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ValidaLoginActivity extends AppCompatActivity {

    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent data = getIntent();

        String email = data.getExtras().getString("email");
        String password = data.getExtras().getString("password");

        message = "Invalid";
        if ((null != email && email.equals("teste")) && (null != password && password.equals("teste"))) {
            message = "Valid";
        }

        finish();
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("message", message);

        setResult(RESULT_OK, intent);

        super.finish();
    }
}
