package com.example.loginwebservice.login_webservice;

import android.os.AsyncTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class LoginAsyncTask extends AsyncTask<String, Integer, String>{

    @Override
    protected String doInBackground(String... params) {
        String NAMESPACE = "http://cliente (veja no wsld em definitions – na realidade corresponde ao nome do pacote em que o serviço foi criado);";
        String METHOD_NAME = "validar";
        String SOAP_ACTION = "ValidaLoginFacade";
        String URL = "http://10.0.2.2:8080/ClienteWS/services/ClienteServico?wsdl";

        SoapSerializationEnvelope envelope = new  SoapSerializationEnvelope(SoapEnvelope.VER11);
        HttpTransportSE transport = new HttpTransportSE(URL);

        try {
            transport.call(SOAP_ACTION, envelope);

            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();

            int result = Integer.parseInt(String.valueOf(response));

        } catch(Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
