package com.example.pablo.prueba7.Modelos;

public class GetDameDatosCAMDOResult {
    public  String Casa;
    public  String Ciudad;
    public  int NUMERO;
    public  String Num_int;
    public  String TELEFONO;
    public  String calle;
    public  String calleEste;
    public  String calleNorte;
    public  String calleOeste;
    public  String calleSur;
    public  String colonia;
    public  String localidad;

    public GetDameDatosCAMDOResult(String casa, String ciudad, int numero, String num_int, String telefono, String calle, String calleEste
            , String calleNorte, String calleOeste, String calleSur, String colonia, String localidad){
        this.Casa = casa;
        this.Ciudad = ciudad;
        this.NUMERO = numero;
        this.Num_int = num_int;
        this.TELEFONO = telefono;
        this.calle = calle;
        this.calleEste = calleEste;
        this.calleNorte = calleNorte;
        this.calleOeste = calleOeste;
        this.calleSur = calleSur;
        this.colonia = colonia;
        this.localidad = localidad;
    }

    public  String getCasa() {
        return Casa;
    }

    public  String getCiudad() {
        return Ciudad;
    }

    public  int getNUMERO() {
        return NUMERO;
    }

    public  String getNum_int() {
        return Num_int;
    }

    public  String getTELEFONO() {
        return TELEFONO;
    }

    public  String getCalle() {
        return calle;
    }

    public  String getCalleEste() {
        return calleEste;
    }

    public  String getCalleNorte() {
        return calleNorte;
    }

    public  String getCalleOeste() {
        return calleOeste;
    }

    public  String getCalleSur() {
        return calleSur;
    }

    public  String getColonia() {
        return colonia;
    }

    public  String getLocalidad() {
        return localidad;
    }


    public void setCasa(String casa) {
        Casa = casa;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }



    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
