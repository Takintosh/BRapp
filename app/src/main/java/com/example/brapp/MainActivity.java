package com.example.brapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnBroadcast1;
    private CustomBroadcast customBroadcast;

    private static final String CUSTOM_ACTION = "com.example.brapp.CUSTOM_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customBroadcast = new CustomBroadcast();

        IntentFilter intentFilter = new IntentFilter(CUSTOM_ACTION);
        registerReceiver(customBroadcast, intentFilter);

        btnBroadcast1 = (Button) findViewById(R.id.btnBroadcast1);
        btnBroadcast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customIntent = new Intent(CUSTOM_ACTION);

                sendBroadcast(customIntent);
                Log.i("MainActivity", "Custom Broadcast Sent");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(customBroadcast);
    }

}