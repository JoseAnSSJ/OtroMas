package com.example.pablo.prueba7.Modelos;


public class Get_ClvTecnicoResult {
    public int clv_tecnico;
    public String tecnico;



    public Get_ClvTecnicoResult(int clv_tecnico,String tecnico) {
        this.clv_tecnico = clv_tecnico;
        this.tecnico=tecnico;
    }

    public int getClv_tecnico() {
        return clv_tecnico;
    }

    public  String getNombre_tec() {
        return tecnico;
    }

}