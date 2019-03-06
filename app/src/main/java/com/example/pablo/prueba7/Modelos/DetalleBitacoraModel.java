package com.example.pablo.prueba7.Modelos;

public class DetalleBitacoraModel {
    public String Descripcion;
    public int IdAlmacen;
    public int catTipoArticuloClave;

    public DetalleBitacoraModel(String descripcion, int idAlmacen, int catTipoArticuloClave) {
        this.Descripcion = descripcion;
        this.IdAlmacen = idAlmacen;
        this.catTipoArticuloClave = catTipoArticuloClave;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void setIdAlmacen(int idAlmacen) {
        IdAlmacen = idAlmacen;
    }

    public void setCatTipoArticuloClave(int catTipoArticuloClave) {
        this.catTipoArticuloClave = catTipoArticuloClave;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getIdAlmacen() {
        return IdAlmacen;
    }

    public int getCatTipoArticuloClave() {
        return catTipoArticuloClave;
    }
}
