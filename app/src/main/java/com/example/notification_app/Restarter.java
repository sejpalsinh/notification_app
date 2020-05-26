package com.example.notification_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;


//CLASS FOR MAKE SERVICE RUN AFTER APP KILLED IT'S WORK LIKE RECEIVER AT TIME OF APP KILL APP WILL BROADCAST AND SERVICE WILL START
public class Restarter extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Broadcast Listened", "Service tried to stop");
        Toast.makeText(context, "Service restarted", Toast.LENGTH_SHORT).show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(new Intent(context, my_service.class));
        } else {
            context.startService(new Intent(context, my_service.class));
        }
    }
}
