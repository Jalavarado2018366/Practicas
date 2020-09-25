package com.example.practicas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Huella extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huella);

        TextView txt_mgs = findViewById(R.id.txt_mgs);
        Button login_btn = findViewById(R.id.login_btn);


        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_SUCCESS:
                txt_mgs.setText("You Can use the fingerprint sensor to login");
                break;

                case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                    txt_mgs.setText(" the device don't have a fingerprint sensor");
                    case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                        txt_mgs.setText();
                case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
        }

    }
}