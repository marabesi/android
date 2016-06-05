package com.example.sqlite.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);

        RegisterDao register = new RegisterDao(this);

        // Simple adapter with users from sqlite
        // ArrayAdapter<Client> adapter = new ArrayAdapter<Client>(this, android.R.layout.simple_list_item_1, register.list());

        ListAdapter adapter = new ListAdapter(this, register.list());

        listView.setAdapter(adapter);

    }
}
