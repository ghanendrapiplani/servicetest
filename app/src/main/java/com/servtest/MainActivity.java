package com.servtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    final String TAG = "main act TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, " main activity");

        try {
            startService(new Intent(getApplicationContext(),  Serv.class));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
