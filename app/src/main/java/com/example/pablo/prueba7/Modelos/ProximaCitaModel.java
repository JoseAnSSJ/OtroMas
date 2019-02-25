package com.example.pablo.prueba7.Modelos;

public class ProximaCitaModel {
    public  String Calle;
    public int Clave;
    public String Colonia;
    public String Contrato;
    public String Hora;
    public  String NUMERO;
    public String Tipo;


    public ProximaCitaModel(String Calle, int Clave, String Colonia, String Contrato, String Hora, String NUMERO, String Tipo){
        this.Calle = Calle;
        this.Clave = Clave;
        this.Colonia = Colonia;
        this.Contrato = Contrato;
        this.Hora = Hora;
        this.NUMERO = NUMERO;
        this.Tipo = Tipo;

    }



    public String getColonia() {
        return Colonia;
    }

    public String getContrato() {
        return Contrato;
    }


    public void setColonia(String colonia) {
        Colonia = colonia;
    }

    public void setContrato(String contrato) {
        Contrato = contrato;
    }

}