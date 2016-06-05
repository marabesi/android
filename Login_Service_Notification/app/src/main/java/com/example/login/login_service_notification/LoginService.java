package com.example.login.login_service_notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LoginService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int flags, int resid) {

        return START_STICKY;
    }

}
