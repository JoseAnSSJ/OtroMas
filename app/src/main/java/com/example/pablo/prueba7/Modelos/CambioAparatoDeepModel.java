package com.example.pablo.prueba7.Modelos;

public class CambioAparatoDeepModel {
    public static int AparatoAsignar;
    public static int AparatoCliente;
    public static int TipoAparatoAsignar;
    public static String StatusEntrega;

    public CambioAparatoDeepModel(int aparatoAsignar, int aparatoCliente, int tipoAparatoAsignar, String statusEntrega) {
        this.AparatoAsignar = aparatoAsignar;
        this.AparatoCliente = aparatoCliente;
        this.TipoAparatoAsignar = tipoAparatoAsignar;
        this.StatusEntrega = statusEntrega;
    }

    public int getAparatoAsignar() {
        return AparatoAsignar;
    }

    public int getAparatoCliente() {
        return AparatoCliente;
    }

    public int getTipoAparatoAsignar() {
        return TipoAparatoAsignar;
    }

    public String getStatusEntrega() {
        return StatusEntrega;
    }
}
