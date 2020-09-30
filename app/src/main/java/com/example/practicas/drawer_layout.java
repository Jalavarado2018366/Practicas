package com.example.practicas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class drawer_layout extends AppCompatActivity {
    private Button whats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        whats = findViewById(R.id.button_w);


        whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AbrirWhatsAppInicio("44361724");
            }
        });
    }


    public void AbrirWhatsAppInicio(String telefono) {
        Intent _intencion = new Intent("android.intent.action.MAIN");
        _intencion.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
        _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators("502" + telefono) + "@s.whatsapp.net");
        startActivity(_intencion);
    }
}