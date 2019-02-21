package com.example.pablo.prueba7.Modelos;

public class ConsultaIpModel {
    public boolean AplicaReintentar;
    public String Msg;

    public ConsultaIpModel(boolean aplicaReintentar, String msg) {
        this.AplicaReintentar = aplicaReintentar;
        this.Msg = msg;
    }

    public boolean isAplicaReintentar() {
        return AplicaReintentar;
    }

    public String getMsg() {
        return Msg;
    }

    public void setAplicaReintentar(boolean aplicaReintentar) {
        AplicaReintentar = aplicaReintentar;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
