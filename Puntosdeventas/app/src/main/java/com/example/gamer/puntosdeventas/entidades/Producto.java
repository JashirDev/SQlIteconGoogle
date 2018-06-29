package com.example.gamer.puntosdeventas.entidades;

import java.io.Serializable;

public class Producto implements Serializable{

    private Integer producto_id;
    private String producto_nombre;

    public Producto(Integer producto_id, String producto_nombre) {
        this.producto_id = producto_id;
        this.producto_nombre = producto_nombre;
    }

    public Producto() {
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }
}
