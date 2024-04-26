package com.example.brapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

public class CustomBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Objects.equals(intent.getAction(), "com.example.brapp.CUSTOM_ACTION")) {
            Toast.makeText(context, "Custom Broadcast Received", Toast.LENGTH_SHORT).show();
            Log.i("CustomBroadcast", "Custom Broadcast Received");
        }

    }

}