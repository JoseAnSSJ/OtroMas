package com.example.pablo.prueba7.Modelos;

public class dameTblPreDescargaMaterialResultModel {
    public int NoExt;
    public int cantidadUtilizada;
    public int clvOrden;
    public int clvTecnico;
    public int contrato;
    public boolean esCable;
    public int idAlmacenEmpresa;
    public int idPreDescarga;
    public int metrajeFin;
    public int metrajeFinExterior;
    public int metrajeInicio;
    public int metrajeInicioExterior;
    public int noArticulo;
    public String tipoDescarga;

    public dameTblPreDescargaMaterialResultModel(int noExt, int cantidadUtilizada, int clvOrden, int clvTecnico, int contrato, boolean esCable, int idAlmacenEmpresa, int idPreDescarga, int metrajeFin, int metrajeFinExterior, int metrajeInicio, int metrajeInicioExterior, int noArticulo, String tipoDescarga) {
        this.NoExt = noExt;
        this.cantidadUtilizada = cantidadUtilizada;
        this.clvOrden = clvOrden;
        this.clvTecnico = clvTecnico;
        this.contrato = contrato;
        this.esCable = esCable;
        this.idAlmacenEmpresa = idAlmacenEmpresa;
        this.idPreDescarga = idPreDescarga;
        this.metrajeFin = metrajeFin;
        this.metrajeFinExterior = metrajeFinExterior;
        this.metrajeInicio = metrajeInicio;
        this.metrajeInicioExterior = metrajeInicioExterior;
        this.noArticulo = noArticulo;
        this.tipoDescarga = tipoDescarga;
    }

    public int getNoExt() {
        return NoExt;
    }

    public int getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public int getClvOrden() {
        return clvOrden;
    }

    public int getClvTecnico() {
        return clvTecnico;
    }

    public int getContrato() {
        return contrato;
    }

    public boolean isEsCable() {
        return esCable;
    }

    public int getIdAlmacenEmpresa() {
        return idAlmacenEmpresa;
    }

    public int getIdPreDescarga() {
        return idPreDescarga;
    }

    public int getMetrajeFin() {
        return metrajeFin;
    }

    public int getMetrajeFinExterior() {
        return metrajeFinExterior;
    }

    public int getMetrajeInicio() {
        return metrajeInicio;
    }

    public int getMetrajeInicioExterior() {
        return metrajeInicioExterior;
    }

    public int getNoArticulo() {
        return noArticulo;
    }

    public String getTipoDescarga() {
        return tipoDescarga;
    }
}
