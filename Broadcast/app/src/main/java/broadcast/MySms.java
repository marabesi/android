package broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MySms extends BroadcastReceiver {
    public MySms() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "hello", Toast.LENGTH_LONG).show();
    }
}
