package com.example.pizza.pizza;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizza.api.Payment;
import com.example.pizza.api.PaymentDao;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Double total = 0.00;
    private RadioGroup group;
    private CheckBox side;
    private Spinner spinnerDynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = (RadioGroup) findViewById(R.id.group);
        int id = group.getCheckedRadioButtonId();

        group.setOnCheckedChangeListener(this);

        side = (CheckBox) findViewById(R.id.side);
        side.setEnabled(false);

        spinnerDynamic = (Spinner) findViewById(R.id.dynamicPayment);

        PaymentDao payments = new PaymentDao();

        ArrayAdapter<Payment> adapter = new ArrayAdapter<Payment>(this,
                android.R.layout.simple_spinner_item, payments.list());

        spinnerDynamic.setAdapter(adapter);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if (checkedId == R.id.flavo1) {
            side.setChecked(false);
            side.setEnabled(false);
        } else {
            side.setEnabled(true);
        }
    }

    public void calculate(View view) {
        RadioButton pizza = (RadioButton) findViewById(group.getCheckedRadioButtonId());

        switch (pizza.getText().toString()) {
            case "Mussarela":
                total = 10.00;
                break;
            case "Calabresa":
                total = 15.00;
                break;
            case "Portuguesa":
                total = 20.00;
                break;
        }

        if (side.isChecked()) {
            total += 5.00;
        }

        TextView labelTotal = (TextView) findViewById(R.id.total);
        labelTotal.setText(total.toString());
    }
}
