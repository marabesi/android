package com.example.rest.rest_app;

<<<<<<< HEAD
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewActivity extends AppCompatActivity {

    private EditText code;
    private EditText description;
    private EditText price;
    private EditText amount;

=======
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewActivity extends AppCompatActivity {

>>>>>>> 0a23cf22b8a610c24384ab0dbe95bf0593d59506
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
<<<<<<< HEAD

        code = (EditText) findViewById(R.id.code);
        description = (EditText) findViewById(R.id.description);
        price = (EditText) findViewById(R.id.price);
        amount = (EditText) findViewById(R.id.amount);

        code.setError("The field Code can't be empty");
        description.setError("The field Description can't be empty");
        price.setError("The field Price can't be empty");
        amount.setError("The field Amount can't be empty");

    }

    public void doSave(View view) {
        SaveAsyncTask save = new SaveAsyncTask();
        save.execute(
                code.getText().toString(),
                description.getText().toString(),
                price.getText().toString(),
                amount.getText().toString()
        );
    }

    private class SaveAsyncTask extends AsyncTask<String, Void, String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = progressDialog.show(NewActivity.this, "Loading", "Saving data on server, please wait");
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(RestService.NEW_PRODUCT);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoOutput(true);

                String parameters = "code=" + params[0] + "&description=" + params[1] + "&price=" + params[2] + "&quantity=" + params[3];

                DataOutputStream outputStream = new DataOutputStream(http.getOutputStream());
                outputStream.writeBytes(parameters);
                outputStream.flush();
                outputStream.close();

                if (http.getResponseCode() == 200) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));

                    String row = "";
                    StringBuilder response = new StringBuilder();

                    while ((row = br.readLine()) != null) {
                        response.append(row);
                    }

                    http.disconnect();

                    return response.toString();
                }
            } catch (Exception e) {
                Log.e(MainActivity.TAG, e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();

            Log.v(MainActivity.TAG, "result - " + s);

            if (null == s) {
                Toast.makeText(NewActivity.this, "There were no response from server", Toast.LENGTH_SHORT);
            } else {
                Log.v(MainActivity.TAG, s);
            }

            finish();
        }
=======
>>>>>>> 0a23cf22b8a610c24384ab0dbe95bf0593d59506
    }
}
