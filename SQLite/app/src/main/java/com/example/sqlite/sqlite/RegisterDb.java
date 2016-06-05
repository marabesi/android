package com.example.sqlite.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RegisterDb extends SQLiteOpenHelper {

    public static final String DATABASE = "register_database";

    public RegisterDb(Context context) {
        super(context, DATABASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + DATABASE + " (id INTEGER " +
                "PRIMARY KEY AUTOINCREMENT, nome_cliente TEXT, cpf INTEGER)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // does nothing
    }
}
