package com.example.broadcast.broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import broadcast.MySms;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void emulate(View view) {
        EditText message = (EditText) findViewById(R.id.message);

        Intent i = new Intent(this, MySms.class);
        i.putExtra("message", message.getText().toString());
        sendBroadcast(i);
    }
}
