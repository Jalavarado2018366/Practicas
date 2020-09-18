package com.example.practicas;

public class Item {

    private final int id;
    private final String price;
    private final String fecha_corte;
    private final String fecha_pago;
    private final String pago_minimo;
    private final String pago_contado;
    private final String saldo_al_corte;
    private final String saldo_al_dia;
    private final int image;

    public Item(int id, String price, String fecha_corte, String fecha_pago, String pago_minimo, String pago_contado, String saldo_al_corte, String saldo_al_dia, int image) {
        this.id = id;
        this.price = price;
        this.fecha_corte = fecha_corte;
        this.fecha_pago = fecha_pago;
        this.pago_minimo = pago_minimo;
        this.pago_contado = pago_contado;
        this.saldo_al_corte = saldo_al_corte;
        this.saldo_al_dia = saldo_al_dia;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getFecha_corte(){ return fecha_corte; }

    public String getFecha_pago(){ return fecha_pago; }

    public String getPago_minimo(){ return  pago_minimo;}

    public String getPago_contado(){ return  pago_contado;}

    public String getSaldo_al_corte(){ return  saldo_al_corte;}

    public String getSaldo_al_dia(){ return saldo_al_dia;}

    public int getImage() {
        return image;
    }
}