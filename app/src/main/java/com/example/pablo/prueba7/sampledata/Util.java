package com.example.pablo.prueba7.sampledata;

import android.content.SharedPreferences;

public class Util {
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;

    public static String getEncoPreference(SharedPreferences preferences){
        return preferences.getString("enco", "");
    }

    public static String getUsuarioPreference(SharedPreferences preferences){
        return preferences.getString("usuario", "");
    }

    public static String getTokenPreference(SharedPreferences preferences){
        return preferences.getString("token", "");
    }

    public static int getClvTecnico(SharedPreferences preferences){
        return preferences.getInt("clvTecnico", 0);
    }
    public static int getClvOrden(SharedPreferences preferences){
        return preferences.getInt("ClvOrden", 0);
    }
    public static int getClvTrabajo(SharedPreferences preferences){
        return preferences.getInt("ClvTrabajo", 0);
    }
    public static int getClv(SharedPreferences preferences){
        return preferences.getInt("Clv", 0);
    }
    public static String getNombreTecnicoPreference(SharedPreferences preferences){
        return preferences.getString("nombre_Tecnico", "");
    }
}
