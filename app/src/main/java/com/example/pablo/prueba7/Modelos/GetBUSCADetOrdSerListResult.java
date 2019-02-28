package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBUSCADetOrdSerListResult {

    @SerializedName("BaseIdUser")
    @Expose
    private Integer baseIdUser;
    @SerializedName("BaseRemoteIp")
    @Expose
    private Object baseRemoteIp;
    @SerializedName("Accion")
    @Expose
    private String accion;
    @SerializedName("Clave")
    @Expose
    public Integer clave;
    @SerializedName("Clv_Orden")
    @Expose
    public Integer clvOrden;
    @SerializedName("Clv_Trabajo")
    @Expose
    private Integer clvTrabajo;
    @SerializedName("Descripcion")
    @Expose
    private String descripcion;
    @SerializedName("Obs")
    @Expose
    private Object obs;
    @SerializedName("SeRealiza")
    @Expose
    private Boolean seRealiza;

    public Integer getBaseIdUser() {
        return baseIdUser;
    }

    public void setBaseIdUser(Integer baseIdUser) {
        this.baseIdUser = baseIdUser;
    }


    public void setBaseRemoteIp(Object baseRemoteIp) {
        this.baseRemoteIp = baseRemoteIp;
    }

    public String getAccion() {
        return accion;
    }


    public Integer getClave() {
        return clave;
    }



    public Integer getClvTrabajo() {
        return clvTrabajo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Object getObs() {
        return obs;
    }

    public void setObs(Object obs) {
        this.obs = obs;
    }

<<<<<<< HEAD
    public Boolean getSeRealiza() {
        return seRealiza;
    }

    public boolean setSeRealiza(Boolean seRealiza) {
        this.seRealiza = seRealiza;
        return false;
    }
=======

>>>>>>> josue1
}