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
                new Item(1, "$12.00 USD", "11/01/2020", "05/07/2020", "Q 0.00", "Q 0.50", "Q 0.00", "Q 971.20","1,220.28 pts","Q 80,000.00","Q 10,423.00","Q 69,576.40","Q 69,576.40","Q 0.00","Q 42,168.00", R.drawable.tarjeta_6),
                new Item(2, "$50.00 USD", "10/01/2020", "12/03/2020", "Q 0.00", "Q 0.00", "Q 5,413.35", "Q 85.00","1,228.47 pts","Q 8,000.00","Q 4,155.13","Q 12,155.13","Q 12,155.13","Q 0.00","Q 42,168.00", R.drawable.tarjeta_22),
                new Item(3, "$265.00 USD", "25/03/2020", "12/10/2020", "Q 0.00", "Q 0.00", "Q 1,605.35", "Q 3,790.72","1,220.28 pts","Q 8,000.00","Q 7,657.68","Q 342.32","Q 342.32","Q 50.32","Q 0.00", R.drawable.tarjeta_33),
                new Item(4,  "$18.00 USD", "15/02/2020", "24/05/2020", "Q 0.00", "Q 0.00", "Q 0.36", "Q 1,574.99","Q 7,731.42 pts","Q 20,000.00","Q 1,574.99","Q 18,425.01","Q 18,425.01","Q 0.00","Q 42,168.00", R.drawable.tarjeta_44));
    }

    public boolean isRated(int itemId) {
        return storage.getBoolean(String.valueOf(itemId), false);
    }

    public void setRated(int itemId, boolean isRated) {
        storage.edit().putBoolean(String.valueOf(itemId), isRated).apply();
    }
}