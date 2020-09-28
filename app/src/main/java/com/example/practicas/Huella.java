package com.example.practicas;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class Huella extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huella);

        TextView txt_mgs = findViewById(R.id.txt_mgs);
        ImageView huella_IV = findViewById(R.id.huella_IV);


        androidx.biometric.BiometricManager biometricManager = androidx.biometric.BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_SUCCESS:
                txt_mgs.setText("Puede usar el sensor de huellas digitales para iniciar sesión");
                break;

            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                txt_mgs.setText(" El dispositivo no tiene sensor de huellas dactilares");
                huella_IV.setVisibility(View.GONE);
                break;

            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                txt_mgs.setText(" The biometric sensor is currently unavailable ");
                huella_IV.setVisibility(View.GONE);
                break;

            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                txt_mgs.setText(" Su dispositivo no tiene ninguna huella digital guardada, verifique su configuración de seguridad ");
                huella_IV.setVisibility(View.GONE);
                break;

        }

        Executor executor = ContextCompat.getMainExecutor(this );

        final BiometricPrompt biometricPrompt = new BiometricPrompt(Huella.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Intent intent = new Intent(Huella.this, Inicio.class);
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("Login")
                .setDescription("Utilice su huella digital para iniciar sesión en su aplicación")
                .setNegativeButtonText("Cancelar")
                .build();


        huella_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);

            }
        });
    }
}