package com.example.pablo.prueba7.Modelos;

public class NoEntregadosModel {

    private Integer clave;
    private Integer clvOrden;
    private Integer clvTrabajo;
    private String descripcion;
    private Object obs;
    private Boolean sweRealiza;
    private Boolean recibi;

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public Integer getClvOrden() {
        return clvOrden;
    }

    public void setClvOrden(Integer clvOrden) {
        this.clvOrden = clvOrden;
    }

    public Integer getClvTrabajo() {
        return clvTrabajo;
    }

    public void setClvTrabajo(Integer clvTrabajo) {
        this.clvTrabajo = clvTrabajo;
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

    public Boolean getSweRealiza() {
        return sweRealiza;
    }

    public void setSweRealiza(Boolean sweRealiza) {
        this.sweRealiza = sweRealiza;
    }

    public Boolean getRecibi() {
        return recibi;
    }

    public void setRecibi(Boolean recibi) {
        this.recibi = recibi;
    }

}