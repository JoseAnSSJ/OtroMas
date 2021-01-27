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

    public String getCALLE() {
        return CALLE;
    }
    public String getCIUDAD() {
        return CIUDAD;
    }
    public String getCOLONIA() {
        return COLONIA;
    }
    public String getNombre() {
        return Nombre;
    }
    public String getNUMERO() {
        return NUMERO;
    }
    public String getApellidoPaterno() { return Apellido_Paterno; }
    public String getApellidoMaterno() {
        return Apellido_Materno;
    }
    public String getCONTRATO() {
        return CONTRATO;
    }

    public void setCALLE(String CALLE) {
        InfoReportesModel.CALLE = CALLE;
    }
    public void setCIUDAD(String CIUDAD) {
        InfoReportesModel.CIUDAD = CIUDAD;
    }
    public void setCOLONIA(String COLONIA) {
        InfoReportesModel.COLONIA = COLONIA;
    }
    public void setNombre(String Nombre) { InfoReportesModel.Nombre = Nombre;}
    public void setNUMERO(String NUMERO) { InfoReportesModel.NUMERO = NUMERO; }
    public void setApellidoPaterno(String Apellido_Paterno) { InfoReportesModel.Apellido_Paterno = Apellido_Paterno; }
    public void setApellidoMaterno(String Apellido_Materno) { InfoReportesModel.Apellido_Materno = Apellido_Materno; }
    public void setCONTRATO(String CONTRATO) { InfoReportesModel.CONTRATO = CONTRATO; }

    }

