package com.example.pablo.prueba7.Modelos;


public class DeepConsModel {
    public static int Contrato;
    public static String ContatoCom;
    public static String STATUS;
    public static String Obs;
    public static int Clv_Orden;
    public static int Clv_TipSer;
    public static String Fec_Sol;

    public DeepConsModel(int Contrato, String ContratoCom, String STATUS, String Obs, Integer Clv_Orden, int clv_TipSer, String fec_Sol){
        this.Contrato = Contrato;
        this.ContatoCom = ContratoCom;
        this.STATUS = STATUS;
        this.Obs = Obs;
        this.Clv_Orden = Clv_Orden;
        this.Clv_TipSer = clv_TipSer;
        this.Fec_Sol = fec_Sol;
    }

    public static int getContrato() {
        return Contrato;
    }
    public void setContrato(int contrato) {
        Contrato = contrato;
    }

    public static String getContatoCom() {
        return ContatoCom;
    }
    public void setContatoCom(String contatoCom) {
        ContatoCom = contatoCom;
    }

    public static String getSTATUS() { return STATUS; }
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public static String getObs() {
        return Obs;
    }
    public static void setObs(String obs) { Obs = obs;}

    public static Integer getClv_Orden() {
        return Clv_Orden;
    }
    public static void setClv_Orden(Integer clv_Orden) {
        Clv_Orden = clv_Orden;
    }

    public static int getClv_TipSer() {
        return Clv_TipSer;
    }
    public static void setClv_TipSer(int clv_TipSer) {
        Clv_TipSer = clv_TipSer;
    }

    public static String getFec_Sol() {
        return Fec_Sol;
    }

    public static void setFec_Sol(String fec_Sol) {
        Fec_Sol = fec_Sol;
    }

    public static void setClv_Orden(int clv_Orden) {
        Clv_Orden = clv_Orden;
    }
}
