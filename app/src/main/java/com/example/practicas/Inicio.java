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
import android.provider.ContactsContract;
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

    private TextView currentItemSaldoPuntos;
    private TextView currentItemLimiteCredito;
    private TextView currentItemCreditoUtilizado;
    private TextView currentItemDisponibleVisa;
    private TextView currentItemDisponibleRetiros;
    private TextView currentItemAutorizaciones;
    private TextView currentItemExtrafinanciamiento;

    private TextView saldo_en_puntos;
    private TextView limite_credito;
    private TextView credito_utilizado;
    private TextView disponible_Visa;
    private TextView disponible_retiros;
    private TextView autorizacion;
    private TextView disponible;
    private TextView extrafinanciamiento;

    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter<?> infiniteAdapter;

    TextView movimiento_1,movimiento_2,movimiento_3,movimiento_4;
    ImageView visible,ocultar,visible1,ocultar1;

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
        currentItemSaldoPuntos = findViewById(R.id.txt_saldoPuntos);
        currentItemLimiteCredito = findViewById(R.id.txt_limiteCredito);
        currentItemCreditoUtilizado = findViewById(R.id.txt_creditoUtilizado);
        currentItemDisponibleVisa = findViewById(R.id.txt_disponibleVisa);
        currentItemDisponibleRetiros = findViewById(R.id.txt_disponibleRetiros);
        currentItemAutorizaciones = findViewById(R.id.txt_Autorizacion);
        currentItemExtrafinanciamiento = findViewById(R.id.txt_Extrafinanciamiento);

        saldo_en_puntos = findViewById(R.id.textView_SaldoPuntos);
        limite_credito = findViewById(R.id.textView_limite_credito);
        credito_utilizado = findViewById(R.id.textView_credito_utilizado);
        disponible_Visa = findViewById(R.id.textView_disponible_visa);
        disponible_retiros = findViewById(R.id.textView_disponible_retiros);
        autorizacion = findViewById(R.id.textView_autorizacion);
        disponible = findViewById(R.id.textView_disponible);
        extrafinanciamiento = findViewById(R.id.textView_extrafinanciamiento);


        movimiento_1 = (TextView) findViewById(R.id.textView7);
        movimiento_2 = (TextView) findViewById(R.id.textView8);
        movimiento_3 = (TextView) findViewById(R.id.vermas);
        movimiento_4 = (TextView) findViewById(R.id.vermas12);
        visible = (ImageView) findViewById(R.id.imageView6);
        ocultar = (ImageView) findViewById(R.id.imageView3);
        visible1 = (ImageView) findViewById(R.id.imageVie);
        ocultar1 = (ImageView) findViewById(R.id.imageVie12);

        findViewById(R.id.imageView3).setOnClickListener(this);
        findViewById(R.id.imageView6).setOnClickListener(this);
        findViewById(R.id.imageVie).setOnClickListener(this);
        findViewById(R.id.imageVie12).setOnClickListener(this);

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
        currentItemSaldoPuntos.setText(item.getSaldo_en_puntos());
        currentItemLimiteCredito.setText(item.getLimite_credito());
        currentItemCreditoUtilizado.setText(item.getCredito_utilizados());
        currentItemDisponibleRetiros.setText(item.getDisponible_retiros());
        currentItemDisponibleVisa.setText(item.getDisponible_visaCuotas());
        currentItemAutorizaciones.setText(item.getAutorizacion());
        currentItemExtrafinanciamiento.setText(item.getExtrafinaciamiento());
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
            case R.id.imageVie:
                if(movimiento_3.getVisibility() == View.VISIBLE){
                    currentItemSaldoPuntos.setVisibility(View.VISIBLE);
                    currentItemLimiteCredito.setVisibility(View.VISIBLE);
                    currentItemCreditoUtilizado.setVisibility(View.VISIBLE);
                    currentItemDisponibleVisa.setVisibility(View.VISIBLE);
                    currentItemDisponibleRetiros.setVisibility(View.VISIBLE);
                    currentItemAutorizaciones.setVisibility(view.VISIBLE);
                    currentItemExtrafinanciamiento.setVisibility(View.VISIBLE);
                    saldo_en_puntos.setVisibility(View.VISIBLE);
                    limite_credito.setVisibility(View.VISIBLE);
                    credito_utilizado.setVisibility(View.VISIBLE);
                    disponible_Visa.setVisibility(View.VISIBLE);
                    disponible_retiros.setVisibility(View.VISIBLE);
                    autorizacion.setVisibility(View.VISIBLE);
                    disponible.setVisibility(View.VISIBLE);
                    extrafinanciamiento.setVisibility(View.VISIBLE);
                    visible1.setVisibility(View.GONE);
                    ocultar1.setVisibility(View.VISIBLE);
                    movimiento_3.setVisibility(View.GONE);
                    movimiento_4.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.imageVie12:
                if(movimiento_4.getVisibility() == View.VISIBLE){
                    currentItemSaldoPuntos.setVisibility(View.GONE);
                    currentItemLimiteCredito.setVisibility(View.GONE);
                    currentItemCreditoUtilizado.setVisibility(View.GONE);
                    currentItemDisponibleVisa.setVisibility(View.GONE);
                    currentItemDisponibleRetiros.setVisibility(View.GONE);
                    currentItemAutorizaciones.setVisibility(view.GONE);
                    currentItemExtrafinanciamiento.setVisibility(View.GONE);
                    saldo_en_puntos.setVisibility(View.GONE);
                    limite_credito.setVisibility(View.GONE);
                    credito_utilizado.setVisibility(View.GONE);
                    disponible_Visa.setVisibility(View.GONE);
                    disponible_retiros.setVisibility(View.GONE);
                    autorizacion.setVisibility(View.GONE);
                    disponible.setVisibility(View.GONE);
                    extrafinanciamiento.setVisibility(View.GONE);
                    visible1.setVisibility(View.VISIBLE);
                    ocultar1.setVisibility(View.GONE);
                    movimiento_3.setVisibility(View.VISIBLE);
                    movimiento_4.setVisibility(View.GONE);
                }
                break;
        }
    }
}