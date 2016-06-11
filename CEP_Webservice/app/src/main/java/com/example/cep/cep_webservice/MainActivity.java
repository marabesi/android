package com.example.cep.cep_webservice;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "CEP";
    private EditText cep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cep = (EditText) findViewById(R.id.cep);
    }

    public void doSearch(View view) {
        CepSearchAsyncTask task = new CepSearchAsyncTask();
        task.execute(cep.getText().toString());
    }

    private class CepSearchAsyncTask extends AsyncTask<String, Integer, String> {

        private ProgressDialog progressDialog;

        @Override
        public void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this, "Loading", "We're searching you data");
        }

        @Override
        protected String doInBackground(String... params) {
            String cep = params[0];
            String webservice = getString(R.string.cep_webservice).replace("%s", cep);


            try {
                URL url = new URL(webservice);

                Log.v(MainActivity.TAG, webservice);

                HttpURLConnection http = (HttpURLConnection) url.openConnection();

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
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            progressDialog.setProgress(100);

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if (null != result) {
                Gson gson = new Gson();
                Cep cepObject = gson.fromJson(result, Cep.class);

                Dialog dialogResult = new Dialog(MainActivity.this);
                dialogResult.setTitle("Result");
                dialogResult.setContentView(R.layout.dialog_cep_layout);

                TextView cep = (TextView) dialogResult.findViewById(R.id.cep);
                cep.setText(cepObject.getCep());

                dialogResult.show();

                Log.v(MainActivity.TAG, result);
            } else {
                Log.v(MainActivity.TAG, "no result found");
            }

            progressDialog.dismiss();
        }
    }
}
