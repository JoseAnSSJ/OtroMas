package com.example.pablo.prueba7.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetMuestraArbolServiciosAparatosPorinstalarListResult {
    @SerializedName("BaseIdUser")
    @Expose
    public Integer BaseIdUser;
    @SerializedName("BaseRemoteIp")
    @Expose
    public Integer BaseRemoteIp;
    @SerializedName("Clv_TipSer")
    @Expose
    public Integer Clv_TipSer;
    @SerializedName("Clv_UnicaNet")
    @Expose
    public Integer Clv_UnicaNet;
    @SerializedName("Contrato")
    @Expose
    public Integer Contrato;
    @SerializedName("Detalle")
    @Expose
    public String Detalle;
    @SerializedName("Expanded")
    @Expose
    public Integer Expanded;
    @SerializedName("IdMedio")
    @Expose
    public Integer IdMedio;
    @SerializedName("Nombre")
    @Expose
    public String Nombre;
    @SerializedName("Tipo")
    @Expose
    public String Tipo;
    @SerializedName("Type")
    @Expose
    public String Type;
    @SerializedName("children")
    @Expose
    public ArrayList<children> children;
    @SerializedName("clv_orden")
    @Expose
    public Integer clv_orden;

    public void setBaseIdUser(Integer baseIdUser) {
        BaseIdUser = baseIdUser;
    }

    public void setBaseRemoteIp(Integer baseRemoteIp) {
        BaseRemoteIp = baseRemoteIp;
    }

    public void setClv_TipSer(Integer clv_TipSer) {
        Clv_TipSer = clv_TipSer;
    }

    public void setClv_UnicaNet(Integer clv_UnicaNet) {
        Clv_UnicaNet = clv_UnicaNet;
    }

    public void setContrato(Integer contrato) {
        Contrato = contrato;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }

    public void setExpanded(Integer expanded) {
        Expanded = expanded;
    }

    public void setIdMedio(Integer idMedio) {
        IdMedio = idMedio;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setChildren(ArrayList<com.example.pablo.prueba7.Modelos.children> children) {
        this.children = children;
    }

    public void setClv_orden(Integer clv_orden) {
        this.clv_orden = clv_orden;
    }

    public Integer getBaseIdUser() {
        return BaseIdUser;
    }

    public Integer getBaseRemoteIp() {
        return BaseRemoteIp;
    }

    public Integer getClv_TipSer() {
        return Clv_TipSer;
    }

    public Integer getClv_UnicaNet() {
        return Clv_UnicaNet;
    }

    public Integer getContrato() {
        return Contrato;
    }

    public String getDetalle() {
        return Detalle;
    }

    public Integer getExpanded() {
        return Expanded;
    }

    public Integer getIdMedio() {
        return IdMedio;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getType() {
        return Type;
    }

    public ArrayList<com.example.pablo.prueba7.Modelos.children> getChildren() {
        return children;
    }

    public Integer getClv_orden() {
        return clv_orden;
    }
}
