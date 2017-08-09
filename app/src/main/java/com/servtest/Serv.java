package com.servtest;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

public class Serv extends Service {
    final String TAG = "SERVICE TEST";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, " Service created ");
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        final Random ran = new Random();
        Log.d(TAG, " Service onstartcommand"+ran.nextInt(1000));
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, " Service check "+ran.nextInt(1000));
                h.postDelayed(this,1000);
            }
        },1000);

        return START_STICKY;
    }
}
