package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMUESTRATRABAJOSQUEJASListResult {
    @SerializedName("BaseIdUser")
    @Expose
    private Long baseIdUser;
    @SerializedName("BaseRemoteIp")
    @Expose
    private Object baseRemoteIp;
    @SerializedName("CLV_TRABAJO")
    @Expose
    public  String cLVTRABAJO;
    @SerializedName("DESCRIPCION")
    @Expose
    public  String dESCRIPCION;
    @SerializedName("TipSer")
    @Expose
    private Object tipSer;
    public GetMUESTRATRABAJOSQUEJASListResult(String clv_trabajo, String descripcion){
        this.cLVTRABAJO = clv_trabajo;
        this.dESCRIPCION = descripcion;
    }

    public Long getBaseIdUser() {
        return baseIdUser;
    }

    public void setBaseIdUser(Long baseIdUser) {
        this.baseIdUser = baseIdUser;
    }

    public void setBaseRemoteIp(Object baseRemoteIp) {
        this.baseRemoteIp = baseRemoteIp;
    }

    public String getDESCRIPCION() {
        return dESCRIPCION;
    }





}


