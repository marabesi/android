package com.example.sqlite.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Client> {
    public ListAdapter(Context context, ArrayList<Client> clients) {
        super(context, 0, clients);
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {

        Client client = getItem(position);


        if (null == convertView) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, viewGroup, false);
        }

        CheckBox ck = (CheckBox) convertView.findViewById(R.id.label);

        ck.setText(client.getName());

        return convertView;
    }
}
