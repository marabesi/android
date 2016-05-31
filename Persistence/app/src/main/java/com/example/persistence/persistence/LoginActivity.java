package com.example.persistence.persistence;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private EditText login;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp = getPreferences(MODE_PRIVATE);
        editor = sp.edit();

        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);

        String txtLogin = sp.getString("login", "").toString();
        String txtPassword = sp.getString("password", "").toString();

        LinearLayout loginLayout = (LinearLayout) findViewById(R.id.layout_login);
        LinearLayout logoutLayout = (LinearLayout) findViewById(R.id.layout_logout);

        if (txtLogin.isEmpty() && txtPassword.isEmpty()) {
            loginLayout.setVisibility(View.VISIBLE);
            logoutLayout.setVisibility(View.INVISIBLE);
        } else {
            loginLayout.setVisibility(View.INVISIBLE);
            logoutLayout.setVisibility(View.VISIBLE);
        }
    }

    public void doLogin(View view) {
        CheckBox keepConnected = (CheckBox) findViewById(R.id.keep_connected);

        if(keepConnected.isChecked()) {
            editor.putString("login", login.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.commit();
        }

        Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void logout(View view) {
        editor.remove("login");
        editor.remove("password");
        editor.commit();

        Toast.makeText(LoginActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
        finish();
    }
}
