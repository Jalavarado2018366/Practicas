package com.example.practicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.widget.Button;
import android.widget.EditText;

public class Pantalla_Principal extends AppCompatActivity {
    private EditText et1,et2;
    private Button buttonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__principal);

        et1 = findViewById(R.id.editTextTextPersonName);
        et2 = findViewById(R.id.editTextTextPassword);

        buttonOk= findViewById(R.id.button);

        if (et1.length() > 0 ){
            buttonOk.setEnabled(true);
        }else{
            buttonOk.setEnabled(false);
        }
        if (et2.length() > 0 ){
            buttonOk.setEnabled(true);
        }else{
            buttonOk.setEnabled(false);
        }
    }
    private void Calcular(String view){

    }
    private void AbrirWhatsApp(String telefono){
        Intent _intencion = new Intent("android.intent.action.MAIN");
        _intencion.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators("502" + telefono)+"@s.whatsapp.net");
        startActivity(_intencion);
    }
}