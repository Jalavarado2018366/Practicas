package com.example.practicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Activity_Pago extends AppCompatActivity implements View.OnClickListener {
    private ImageView service_inactivo, service_activo, credit_card_inactivo, credit_card_activo, loan_inactivo, loan_activo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pago);
        service_inactivo = (ImageView) findViewById(R.id.view_service_inactivo);
        service_activo = (ImageView) findViewById(R.id.view_service_activo);
        credit_card_inactivo = (ImageView) findViewById(R.id.view_credit_card_inactivo);
        credit_card_activo = (ImageView) findViewById(R.id.view_credit_card_activo);
        loan_inactivo = (ImageView) findViewById(R.id.view_loan_inactivo);
        loan_activo = (ImageView) findViewById(R.id.view_loan_activo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_service_inactivo:
                if (service_inactivo.getVisibility() == View.GONE) {
                    service_activo.setVisibility(View.VISIBLE);
                    service_inactivo.setVisibility(View.GONE);
                } else {
                    service_activo.setVisibility(View.GONE);
                    service_inactivo.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.view_credit_card_activo:
                if (service_activo.getVisibility() == View.VISIBLE) {
                    service_activo.setVisibility(View.GONE);
                    service_inactivo.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}