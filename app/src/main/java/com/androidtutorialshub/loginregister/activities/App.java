package com.androidtutorialshub.loginregister.activities;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String  CHANNEL_1_ID="channel1";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationsChannels();
    }
    private void createNotificationsChannels(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O);
        {
            NotificationChannel channel=new NotificationChannel(
                    CHANNEL_1_ID,
                    "channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("This is channel 1");


        }
    }
}
