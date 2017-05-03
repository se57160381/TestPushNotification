package com.bas.testpushnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by BassAye on 27/4/2560.
 */

public class MyFirebaseMessaginService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationBuider = new NotificationCompat.Builder(this);
        notificationBuider.setContentTitle("TEST NOTIFICATION");
        notificationBuider.setContentText(remoteMessage.getNotification().getBody());
        notificationBuider.setAutoCancel(true);
        notificationBuider.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuider.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuider.build());
    }
}

