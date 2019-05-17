package com.sknchip.epaperwatch;

import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

public class NotificationListener extends NotificationListenerService {
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn){
        // TODO update notification count upon posting new one
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn){
        // TODO update notification count upon removing one
    }
}
