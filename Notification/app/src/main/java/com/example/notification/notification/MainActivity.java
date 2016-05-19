package com.example.notification.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void send(View view) {
        EditText title = (EditText) findViewById(R.id.title);

        Switch vibrate = (Switch) findViewById(R.id.vibrate);
        Switch sound = (Switch) findViewById(R.id.sound);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setPriority(BIND_IMPORTANT);
        builder.setContentTitle(title.getText().toString());
        builder.setTicker("Look here");
        builder.setContentText("Message goes here");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        if (vibrate.isActivated()) {
            Notification notification = builder.build();
            notification.vibrate = new long[]{150, 300, 150,600};
        }

        if (sound.isChecked()) {
            Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone ringtone = RingtoneManager.getRingtone(this, notificationSound);
            ringtone.play();
        }


        notificationManager.notify(1, builder.build());
    }
}
