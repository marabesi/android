package com.example.paulooliveira.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        EditText numberOne = (EditText) findViewById(R.id.number_one);
        Integer valueOne = Integer.parseInt(numberOne.getText().toString());

        EditText numberTwo = (EditText) findViewById(R.id.number_two);
        Integer valueTwo = Integer.parseInt(numberTwo.getText().toString());

        Integer result = valueOne + valueTwo;

//        Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Resultado");
        dialog.setMessage(result.toString());
        dialog.setPositiveButton("OK", null);
        dialog.show();
    }
}
