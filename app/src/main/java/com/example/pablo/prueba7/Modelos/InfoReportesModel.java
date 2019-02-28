package com.example.pablo.prueba7.Modelos;


public class InfoReportesModel {





    public static String CALLE;
    public static String CIUDAD;
    public static String COLONIA;
    public static String Nombre;
    public static String NUMERO;
    public static String Apellido_Materno;
    public static String Apellido_Paterno;
    public static String CONTRATO;





    public InfoReportesModel(String CALLE, String CIUDAD, String COLONIA, String NOMBRE, String NUMERO, String Apellido_Paterno, String Apellido_Materno) {
        this.CALLE=CALLE;
        this.CIUDAD=CIUDAD;
        this.COLONIA=COLONIA;
        this.Nombre=NOMBRE;
        this.NUMERO=NUMERO;
        this.Apellido_Paterno=Apellido_Paterno;
        this.Apellido_Materno=Apellido_Materno;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) { InfoReportesModel.Nombre = Nombre;}


    }

