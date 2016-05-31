package broadcast;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MySms extends BroadcastReceiver {
    public MySms() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();

        Toast.makeText(context, extras.getString("message"), Toast.LENGTH_LONG).show();
    }
}
