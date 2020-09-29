package com.example.practicas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;import android.widget.Toast;

public class Activity_Login extends AppCompatActivity {
    private EditText txt_Usuario, txt_Contrasena;
    private Button buttonOk;
    private Button button_huella;
    private ImageView imageButton;
    private ImageView whatsApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);
        txt_Usuario = findViewById(R.id.txt_user);
        txt_Contrasena = findViewById(R.id.txt_password);
        final Activity_LoadinDialog activity_loadinDialog = new Activity_LoadinDialog(Activity_Login.this);
        buttonOk = findViewById(R.id.button);
        whatsApp = findViewById(R.id.imageButton2);
        button_huella = findViewById(R.id.button_huella);


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
                    activity_loadinDialog.startLoadingDialog();
                    Handler handler = new Handler( );
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            activity_loadinDialog.dimissDialog();
                            Intent intent = new Intent(getApplicationContext(),Inicio.class);
                            startActivity(intent);
                        }
                    },2000);
                }else {
                    Toast.makeText(getApplicationContext(), " verify your email or password ", Toast.LENGTH_SHORT).show();
                }
            }

        });

        //Huella
        button_huella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_loadinDialog.startLoadingDialog();
                Handler handler = new Handler( );
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        activity_loadinDialog.dimissDialog();
                        Intent intent = new Intent(getApplicationContext(),Huella.class);
                        startActivity(intent);
                    }
                },2000);
            }
        });

        //Sucursales
        imageButton = (ImageView)findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),activity_mapas.class);
                startActivity(intent);
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