package com.example.project_spktht;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.Manifest;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

public class PushNotificationService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        getFirebaseMessage(getApplicationContext(), remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody(), intent);
    }

    private void getFirebaseMessage(Context context, String title, String msg, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        int notificationId = 1;
        String channelId = "Channel1";
        String channelName = "My Channel";
        int important = NotificationManager.IMPORTANCE_HIGH;

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, important
            );
            notificationManager.createNotificationChannel(mChannel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true);

        PendingIntent intent1 = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_MUTABLE);
        mBuilder.setContentIntent(intent1);
        notificationManager.notify(notificationId, mBuilder.build());
    }


}
