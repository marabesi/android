package com.example.sqlite.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RegisterDao registerDao;
    EditText name;
    EditText cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerDao = new RegisterDao(this);

        name = (EditText) findViewById(R.id.name);
        cpf = (EditText) findViewById(R.id.cpf);
    }

    public void register(View view) {
        Client client = new Client();
        client.setName(name.getText().toString());
        client.setCpf(cpf.getText().toString());

        registerDao.insert(client);

        Toast.makeText(this, "Inserted successfuly", Toast.LENGTH_SHORT).show();

        name.setText("");
        cpf.setText("");

        doList();
    }

    public void doList() {
        Intent list = new Intent(this, ListActivity.class);
        startActivity(list);
    }

    public void list(View view) {
        doList();
    }
}
