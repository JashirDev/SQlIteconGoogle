package com.example.gamer.puntosdeventas.entidades;

public class Usuario {
    private Integer usu_id;
    private String usu_nombre;
    private String usu_password;

    public Usuario(Integer usu_id, String usu_nombre, String usu_password) {
        this.usu_id = usu_id;
        this.usu_nombre = usu_nombre;
        this.usu_password = usu_password;
    }

    public Integer getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Integer usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public String getUsu_password() {
        return usu_password;
    }

    public void setUsu_password(String usu_password) {
        this.usu_password = usu_password;
    }
}
