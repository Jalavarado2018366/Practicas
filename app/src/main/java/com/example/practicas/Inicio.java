package com.example.practicas;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class Inicio extends AppCompatActivity {

    private int[] tarjetas = new int[] {
            R.drawable.tarjeta_1, R.drawable.tarjeta_2, R.drawable.tarjeta_3, R.drawable.tarjeta_4
    };

    private String[] tarjetasTitle = new String[] {
            "1", "2", "3", "4"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        CarouselView carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(tarjetas.length);
        carouselView.setIndicatorVisibility(View.GONE);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(tarjetas[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(Inicio.this, tarjetas[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}