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
    private final String saldo_en_puntos;
    private final String limite_credito;
    private final String credito_utilizados;
    private final String disponible_visaCuotas;
    private final String disponible_retiros;
    private final String autorizacion;
    private final String extrafinaciamiento;
    private final int image;

    public Item(int id, String price, String fecha_corte, String fecha_pago, String pago_minimo, String pago_contado, String saldo_al_corte, String saldo_al_dia, String saldo_en_puntos, String limite_credito, String credito_utilizados, String disponible_visaCuotas, String disponible_retiros, String autorizacion, String extrafinaciamiento, int image) {
        this.id = id;
        this.price = price;
        this.fecha_corte = fecha_corte;
        this.fecha_pago = fecha_pago;
        this.pago_minimo = pago_minimo;
        this.pago_contado = pago_contado;
        this.saldo_al_corte = saldo_al_corte;
        this.saldo_al_dia = saldo_al_dia;
        this.saldo_en_puntos = saldo_en_puntos;
        this.limite_credito = limite_credito;
        this.credito_utilizados = credito_utilizados;
        this.disponible_visaCuotas = disponible_visaCuotas;
        this.disponible_retiros = disponible_retiros;
        this.autorizacion = autorizacion;
        this.extrafinaciamiento = extrafinaciamiento;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getFecha_corte() {
        return fecha_corte;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public String getPago_minimo() {
        return pago_minimo;
    }

    public String getPago_contado() {
        return pago_contado;
    }

    public String getSaldo_al_corte() {
        return saldo_al_corte;
    }

    public String getSaldo_al_dia() {
        return saldo_al_dia;
    }

    public String getSaldo_en_puntos() {
        return saldo_en_puntos;
    }

    public String getLimite_credito() {
        return limite_credito;
    }

    public String getCredito_utilizados() {
        return credito_utilizados;
    }

    public String getDisponible_visaCuotas() {
        return disponible_visaCuotas;
    }

    public String getDisponible_retiros() {
        return disponible_retiros;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public String getExtrafinaciamiento() {
        return extrafinaciamiento;
    }

    public int getImage() {
        return image;
    }
}