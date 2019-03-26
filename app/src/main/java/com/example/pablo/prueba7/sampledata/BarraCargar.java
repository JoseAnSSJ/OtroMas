package com.example.pablo.prueba7.sampledata;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

public class BarraCargar {
    public ProgressDialog showDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Cargando...");
        return progressDialog;

    }
 /*   public void dismissDialog(ProgressDialog progressDialog,Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.dismiss();

    }*/
}
