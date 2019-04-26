package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMuestraAparatosDisponiblesListResult {
    @SerializedName("Clv_Aparato")
    @Expose
    public Integer clv_Aparato;
    @SerializedName("Descripcion")
    @Expose
    private String descripcion;
    @SerializedName("Letra")
    @Expose
    public  String letra;

    public String getLetra() {
        return letra;
    }

    public Integer getClv_Aparato() {
        return clv_Aparato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
