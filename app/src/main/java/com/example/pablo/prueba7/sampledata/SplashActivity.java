package com.example.pablo.prueba7.sampledata;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.example.pablo.prueba7.Activitys.Inicio;
import com.example.pablo.prueba7.Activitys.Login;
import com.example.pablo.prueba7.Request.Request;

import org.json.JSONObject;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    public static boolean LoginShare=false;
    public JSONObject jsonObject,jsonObject1=new JSONObject();
    Request request = new Request();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        if (!TextUtils.isEmpty(Util.getTokenPreference(preferences))) {
            LoginShare=true;
            Intent intentinicio = new Intent(this, Inicio.class);
            startActivity(intentinicio);

        } else {
            Intent intentLogin = new Intent(this, Login.class);
            startActivity(intentLogin);
            LoginShare=false;
        }
        finish();
    }
}
