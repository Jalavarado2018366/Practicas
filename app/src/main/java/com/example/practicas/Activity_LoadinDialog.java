package com.example.practicas;

import android.app.Activity;

import android.app.AlertDialog;
import android.view.LayoutInflater;

public class Activity_LoadinDialog {

    Activity activity;
    AlertDialog dialog;

    Activity_LoadinDialog(Activity myActivity) {
        activity = myActivity;
    }

    void startLoadingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.activity__loadin_dialog, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }

    void dimissDialog() {
        dialog.dismiss();
    }
}