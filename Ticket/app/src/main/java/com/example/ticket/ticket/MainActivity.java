package com.example.ticket.ticket;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.api.ModalityCollection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ModalityCollection list = new ModalityCollection();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list.fetch());

        Spinner modality = (Spinner) findViewById(R.id.modality);
        modality.setAdapter(arrayAdapter);
    }

    public void show(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_main);
        dialog.setTitle("Confirmação");

        TextView name = (TextView) dialog.findViewById(R.id.name);
        name.setText("Teste");

        TextView age = (TextView) dialog.findViewById(R.id.age);
        age.setText("1");

        TextView modality = (TextView) dialog.findViewById(R.id.modality);
        modality.setText("Futebol");

        TextView period = (TextView) dialog.findViewById(R.id.period);
        period.setText("Manhã");

        dialog.show();
    }
}
