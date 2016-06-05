package com.example.rest.rest_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "REST_APP";

    private ListView listView;
    private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (EditText) findViewById(R.id.search);
        listView = (ListView) findViewById(R.id.listView);
    }

    public void doSearch(View view) {
        SearchAsyncTask task = new SearchAsyncTask();
        task.execute(search.getText().toString());
    }

    public void insert(View view) {
        Intent insert = new Intent(this, NewActivity.class);
        startActivity(insert);
    }

    private class SearchAsyncTask extends AsyncTask<String, Void,String> {

        private ProgressDialog progress;
        private boolean byCode = false;


        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(MainActivity.this, "Loading", "Searching on server");
        }

        @Override
        protected String doInBackground(String... params) {
            String service = RestService.FETCH_ALL;

            try {
                long code = Integer.parseInt(params[0]);

                service = RestService.FETCH_ONE.replace("{?}", params[0]);

                byCode = true;
            } catch (NumberFormatException e) {
                Log.e(MainActivity.TAG, "Could not fetch by code " + params[0]);
            }

            Log.v(MainActivity.TAG, "Fetch data from " + service);

            try {
                URL url = new URL(service);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("GET");

                if (http.getResponseCode() == 200) {
                    BufferedReader stream = new BufferedReader(new InputStreamReader(http.getInputStream()));

                    String row = "";
                    StringBuilder response = new StringBuilder();

                    while((row = stream.readLine()) != null) {
                        response.append(row);
                    }

                    http.disconnect();

                    return response.toString();
                }
            } catch(Exception e) {
                Log.e(TAG, e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.v(MainActivity.TAG, "response " + s);

            if (s != null) {
                try {
                    Gson json = new Gson();

                    Product[] list = new Product[1];

                    ArrayAdapter adapter = null;

                    if (byCode) {
                        Product p = json.fromJson(s, Product.class);
                        list[0] = p;

                        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
                    } else {
                        Product[] arraylist = json.fromJson(s, Product[].class);
                        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arraylist);
                    }

                    listView.setAdapter(adapter);

                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
            progress.dismiss();
        }
    }
}