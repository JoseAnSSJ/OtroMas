package com.example.pablo.prueba7.Modelos;

public class UserModel {
    private String Usuario;
    public static String Token;
    public static String Codigo;
    public static int Id_Usuario;


    public UserModel(String Usuario, String Token, String codigo, int id_Usuario) {
        this.Usuario = Usuario;
        this.Token = Token;
        this.Codigo=codigo;
        this.Id_Usuario = id_Usuario;

    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public static String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) { Codigo = codigo; }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        Id_Usuario = id_Usuario;
    }
}