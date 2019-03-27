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

    public static void setAparatoAsignar(int aparatoAsignar) {
        AparatoAsignar = aparatoAsignar;
    }

    public static void setAparatoCliente(int aparatoCliente) {
        AparatoCliente = aparatoCliente;
    }

    public static void setTipoAparatoAsignar(int tipoAparatoAsignar) {
        TipoAparatoAsignar = tipoAparatoAsignar;
    }

    public static void setStatusEntrega(String statusEntrega) {
        StatusEntrega = statusEntrega;
    }
}
