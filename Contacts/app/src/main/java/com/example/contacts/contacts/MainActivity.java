package com.example.contacts.contacts;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import android.Manifest;

public class MainActivity extends AppCompatActivity {

    public final int REQUEST_PERMISSIONS_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.READ_CONTACTS) !=
                        PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_PERMISSIONS_CODE);
        } else {

            ContentResolver resolver = getContentResolver();
            Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;

            Cursor cursor = resolver.query(CONTENT_URI, null, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(
                            cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                } while (cursor.moveToNext());
            }

            cursor.close();
        }
    }
}
