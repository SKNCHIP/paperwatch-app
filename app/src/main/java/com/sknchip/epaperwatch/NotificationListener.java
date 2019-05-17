package com.sknchip.epaperwatch;

import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class NotificationListener extends NotificationListenerService {

    public NotificationListener(){
        super();
        Log.d(TAG,"Service created!");
    }

    private static final String TAG = NotificationListener.class.getSimpleName();
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn){
        Log.d(TAG, "Posted: " + sbn.getTag());
        broadcastNotificationCount();
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn){
        Log.d(TAG, "Removed!" + sbn.getTag());
        broadcastNotificationCount();
    }

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();
        Log.d(TAG,"Listener connected!");
        broadcastNotificationCount();
    }

    private void broadcastNotificationCount() {
        Intent intent = new  Intent("com.sknchip.epaperwatch");
        int notificationCount = getActiveNotifications().length;
        intent.putExtra("Notification Count", notificationCount);
        sendBroadcast(intent);
        Log.d(TAG, "Count: "+notificationCount);
    }
}
