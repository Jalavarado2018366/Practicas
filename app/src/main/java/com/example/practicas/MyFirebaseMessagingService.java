package com.example.practicas;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        Log.i("PVL", "MESSAGE RECEIVED!!");
        if (remoteMessage.getNotification().getBody() != null) {
            Log.i("PVL", "RECEIVED MESSAGE: " + remoteMessage.getNotification().getBody());
        } else {
            Log.i("PVL", "RECEIVED MESSAGE: " + remoteMessage.getData().get("message"));
        }
    }
}


///https://www.bancopromerica.com.gt/recursos/landing/2020/julio/cobros/images/logo_banco_promerica.png