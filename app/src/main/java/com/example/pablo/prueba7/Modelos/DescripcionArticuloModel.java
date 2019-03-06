package com.example.pablo.prueba7.Modelos;

public class DescripcionArticuloModel {
    public int Cantidad;
    public int IdArticulo;
    public int IdInventario;
    public String Nombre;

    public DescripcionArticuloModel(int cantidad, int idArticulo, int idInventario, String nombre) {
        this.Cantidad = cantidad;
        this.IdArticulo = idArticulo;
        this.IdInventario = idInventario;
        this.Nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public void setIdArticulo(int idArticulo) {
        IdArticulo = idArticulo;
    }

    public void setIdInventario(int idInventario) {
        IdInventario = idInventario;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public int getIdArticulo() {
        return IdArticulo;
    }

    public int getIdInventario() {
        return IdInventario;
    }

    public String getNombre() {
        return Nombre;
    }
}
