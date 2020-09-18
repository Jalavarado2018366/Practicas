package com.example.practicas;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.material.snackbar.Snackbar;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;

public class Inicio extends AppCompatActivity implements DiscreteScrollView.OnItemChangedListener<ShopAdapter.ViewHolder>,
        View.OnClickListener {
    private Button Abrir_Whatsapp;
    private ImageButton Notification;
    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 0;

    private List<Item> data;
    private Shop shop;
    private TextView currentItemName;
    private TextView currentItemPrice;
    private TextView currentItemfechaCorte;
    private TextView currentItemfechaPago;
    private TextView currentItemPagoMinimo;
    private TextView currentItemPagoContado;
    private TextView currentItemSaldoCorte;
    private TextView currentItemSaldoDia;
    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter<?> infiniteAdapter;

    TextView movimiento_1,movimiento_2;
    ImageView visible,ocultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Abrir_Whatsapp = findViewById(R.id.button_w);
        Notification = findViewById((R.id.btNotification));
        currentItemPrice = findViewById(R.id.item_price);
        currentItemfechaCorte = findViewById(R.id.txt_fechaCorte);
        currentItemfechaPago = findViewById(R.id.txt_fechaPago);
        currentItemPagoMinimo = findViewById(R.id.txt_pagoMinimo);
        currentItemPagoContado = findViewById(R.id.txt_pagoContado);
        currentItemSaldoCorte = findViewById(R.id.txt_pagoCorte);
        currentItemSaldoDia = findViewById(R.id.txt_pagoDia);

        movimiento_1 = (TextView) findViewById(R.id.textView7);
        movimiento_2 = (TextView) findViewById(R.id.textView8);
        visible = (ImageView) findViewById(R.id.imageView6);
        ocultar = (ImageView) findViewById(R.id.imageView3);

        findViewById(R.id.imageView3).setOnClickListener(this);
        findViewById(R.id.imageView6).setOnClickListener(this);

        shop = Shop.get();
        data = shop.getData();
        itemPicker = findViewById(R.id.item_picker);
        itemPicker.setOrientation(DSVOrientation.HORIZONTAL);
        itemPicker.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new ShopAdapter(data));
        itemPicker.setAdapter(infiniteAdapter);
        itemPicker.setItemTransitionTimeMillis(DiscreteScrollViewOptions.getTransitionTime());
        itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        onItemChanged(data.get(0));

        Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotification();
                createNotificationChannel();
            }
        });
        Abrir_Whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AbrirWhatsAppInicio( "44361724");
            }
        });

    }
    private void onItemChanged(Item item) {
        currentItemPrice.setText(item.getPrice());
        currentItemfechaCorte.setText(item.getFecha_corte());
        currentItemfechaPago.setText(item.getFecha_pago());
        currentItemPagoMinimo.setText(item.getPago_minimo());
        currentItemPagoContado.setText(item.getPago_contado());
        currentItemSaldoCorte.setText(item.getSaldo_al_corte());
        currentItemSaldoDia.setText(item.getSaldo_al_dia());
    }
    @Override
    public void onCurrentItemChanged(@Nullable ShopAdapter.ViewHolder viewHolder, int adapterPosition) {
        int positionInDataSet = infiniteAdapter.getRealPosition(adapterPosition);
        onItemChanged(data.get(positionInDataSet));
    }

    private void showUnsupportedSnackBar() {
        Snackbar.make(itemPicker, R.string.msg_unsupported_op, Snackbar.LENGTH_SHORT).show();
    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Noticacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
    private void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.estrella_redondeada);
        builder.setContentTitle("Notificacion Android");
        builder.setContentText("Prueba");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.MAGENTA, 1000, 1000);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        builder.setDefaults(android.app.Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());
    }
    public void AbrirWhatsAppInicio(String telefono) {
        Intent _intencion = new Intent("android.intent.action.MAIN");
        _intencion.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
        _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators("502" + telefono) + "@s.whatsapp.net");
        startActivity(_intencion);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView3:
                if(movimiento_1.getVisibility() == View.GONE){
                    movimiento_1.setVisibility(View.VISIBLE);
                    movimiento_2.setVisibility(View.VISIBLE);
                    visible.setVisibility(View.VISIBLE);
                    ocultar.setVisibility(View.GONE);
                }
                break;
            case R.id.imageView6:
                if(movimiento_1.getVisibility() == View.VISIBLE){
                    movimiento_1.setVisibility(View.GONE);
                    movimiento_2.setVisibility(View.GONE);
                    visible.setVisibility(View.GONE);
                    ocultar.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}