package com.example.practicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Pantalla_Principal extends AppCompatActivity {
    private EditText txt_Usuario, txt_Contrasena;
    private Button buttonOk;
    private ImageView whatsApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__principal);
        txt_Usuario = findViewById(R.id.txt_user);
        txt_Contrasena = findViewById(R.id.txt_password);

        buttonOk = findViewById(R.id.button);
        whatsApp = findViewById(R.id.imageButton2);

        whatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AbrirWhatsApp( "44361724");
            }
        });

        txt_Usuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                buttonOk.setEnabled(txt_Usuario.length() > 0);
            }
        });
        txt_Contrasena.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                buttonOk.setEnabled(txt_Contrasena.length() > 0);
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                String V_User = txt_Usuario.getText().toString();
                txt_Usuario.setText("");
                String V_Pass = txt_Contrasena.getText().toString();
                txt_Contrasena.getText().clear();
                if(V_User.equals("kinal@gmail.com") && V_Pass.equals("123")){
                    Intent intent = new Intent(getApplicationContext(),Inicio.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "verify your email or password", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }


    public void AbrirWhatsApp(String telefono) {
        Intent _intencion = new Intent("android.intent.action.MAIN");
        _intencion.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
        _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators("502" + telefono) + "@s.whatsapp.net");
        startActivity(_intencion);
    }
}