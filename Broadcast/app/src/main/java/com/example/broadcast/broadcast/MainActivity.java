package com.example.broadcast.broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import broadcast.MySms;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // testing the broadcast
        Intent i = new Intent(this, MySms.class);
        sendBroadcast(i);
    }
}
