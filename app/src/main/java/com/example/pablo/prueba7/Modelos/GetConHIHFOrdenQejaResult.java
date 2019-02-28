package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetConHIHFOrdenQejaResult {
    @SerializedName("BaseIdUser")
    @Expose
    private Long baseIdUser;
    @SerializedName("BaseRemoteIp")
    @Expose
    private Object baseRemoteIp;
    @SerializedName("HoraFin")
    @Expose
    private Object horaFin;
    @SerializedName("HoraIni")
    @Expose
    private Object horaIni;

    public Long getBaseIdUser() {
        return baseIdUser;
    }

    public void setBaseIdUser(Long baseIdUser) {
        this.baseIdUser = baseIdUser;
    }

    public Object getBaseRemoteIp() {
        return baseRemoteIp;
    }

    public void setBaseRemoteIp(Object baseRemoteIp) {
        this.baseRemoteIp = baseRemoteIp;
    }

    public Object getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Object horaFin) {
        this.horaFin = horaFin;
    }

    public Object getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(Object horaIni) {
        this.horaIni = horaIni;
    }

}
