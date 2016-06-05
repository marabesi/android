package com.example.sqlite.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

public class RegisterDao {
    private static int VERSION = 1;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public RegisterDao(Context context) {
        this.context = context;

        RegisterDb helper = new RegisterDb(context);

        this.sqLiteDatabase = helper.getWritableDatabase();
    }

    public boolean insert(Client client) {
        String insert = "insert into " + RegisterDb.DATABASE + "(nome_cliente, cpf) VALUES (?, ?)";

        SQLiteStatement smt = sqLiteDatabase.compileStatement(insert);
        smt.bindString(1, client.getName());
        smt.bindString(2, client.getCpf());

        if (smt.executeInsert() > 0) {
            return true;
        }

        return false;
    }

    public ArrayList list() {
        ArrayList<Client> list = new ArrayList<Client>();

        Cursor cursor = sqLiteDatabase.query(RegisterDb.DATABASE, new String[] {"nome_cliente", "cpf"}, null, null, null, null, "id desc");
        cursor.moveToFirst();

        do {
            Client c1 = new Client();
            c1.setName(cursor.getString(0));
            c1.setCpf(cursor.getString(1));
            list.add(c1);
        } while (cursor.moveToNext());

        cursor.close();

        return list;
    }
}
