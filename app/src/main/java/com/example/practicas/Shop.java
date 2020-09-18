package com.example.practicas;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yarolegovich on 07.03.2017.
 */

public class Shop {

    private static final String STORAGE = "shop";

    public static Shop get() {
        return new Shop();
    }

    private SharedPreferences storage;

    private Shop() {
        storage = App.getInstance().getSharedPreferences(STORAGE, Context.MODE_PRIVATE);
    }

    public List<Item> getData() {
        return Arrays.asList(
                new Item(1, "$12.00 USD", "11/01/2020", "05/07/2020", "Q 12.00", "Q 120.50", "Q 19.00", "Q 90.00", R.drawable.tarjeta_6),
                new Item(2, "$50.00 USD", "10/01/2020", "12/03/2020", "Q 200.00", "Q 52.00", "Q 2.00", "Q 85.00", R.drawable.tarjeta_22),
                new Item(3, "$265.00 USD", "25/03/2020", "12/10/2020", "Q 12.50", "Q 89.00", "Q 16.00", "Q 52.00", R.drawable.tarjeta_33),
                new Item(4,  "$18.00 USD", "15/02/2020", "24/05/2020", "Q 5.30", "Q 85.00", "Q 127.80", "Q 74.00", R.drawable.tarjeta_44));
    }

    public boolean isRated(int itemId) {
        return storage.getBoolean(String.valueOf(itemId), false);
    }

    public void setRated(int itemId, boolean isRated) {
        storage.edit().putBoolean(String.valueOf(itemId), isRated).apply();
    }
}