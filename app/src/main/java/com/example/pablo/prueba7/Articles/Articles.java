package com.example.pablo.prueba7.Articles;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.pablo.prueba7.Adapters.quejas_adapter_result.clvReport;

public class Articles {
    private String fecha_ejecucion;
    private String hora;
    private String tipo_solucion;
    private String solucion;
    private String visita1;
    private String visita2;
    private String visita3;

    public Articles(String selectD, String selectD1, String selectD2, String selectD3, String selectT, String selectT2, String tipo_solucion, String solucion) {
        this.fecha_ejecucion = selectD;
        this.hora =selectT.concat(selectT2);
        this.tipo_solucion = tipo_solucion;
        this.solucion=solucion;
        this.visita1=selectD1;
        this.visita2=selectD2;
        this.visita3=selectD3;
    }

    public String getfecha_ejecucion() {
        return fecha_ejecucion;
    }

    public void setfecha_ejecucion(String fecha_ejecucion) {
        this.fecha_ejecucion = fecha_ejecucion;
    }

    public String gethora() {
        return hora;
    }

    public void sethora(String hora) {
        this.hora =hora ;
    }

    public String gettipo_solucion() {
        return tipo_solucion;
    }

    public void settipo_solucion(String tipo_solucion) {
        this.tipo_solucion = tipo_solucion;
    }
    public String getSolucion() {
     return solucion;
    }
    public void setSolucion(String solucion) {
    this.solucion=solucion;

    }




    public String getVisita1() {
        return visita1;
    }
    public void setVisita1(String Visita1) {
        this.visita1=Visita1;

    }
    public String getVisita2() {
        return visita2;
    }
    public void setVisita2(String visita2) {
        this.visita2=visita2;

    }
    public String getVisita3() {
        return visita3;
    }
    public void setVisita3(String visita3) {
        this.visita3=visita3;

    }

    public String toJSON(){

        JSONObject jsonObject= new JSONObject();
        try {
            jsonObject.put("Clv_Queja", clvReport);
            jsonObject.put("Fecha_Ejecucion", getfecha_ejecucion());
            jsonObject.put("TipoSolucion", gettipo_solucion());
            jsonObject.put("Solucion", getSolucion());
            jsonObject.put("Fecha_Ejecucion", gethora());
            jsonObject.put("Visita1",getVisita1());
            jsonObject.put("Visita2",getVisita2());
            jsonObject.put("Visita3",getVisita3());



            return jsonObject.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}







