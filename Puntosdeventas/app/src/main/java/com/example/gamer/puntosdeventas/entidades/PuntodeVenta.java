package com.example.gamer.puntosdeventas.entidades;

import java.io.Serializable;

public class PuntodeVenta implements Serializable{
    private Integer pv_id;
    private String pv_nombre;
    private Double pv_latitud;
    private Double pv_longitud;

    public PuntodeVenta() {
    }

    public PuntodeVenta(Integer pv_id, String pv_nombre, Double pv_latitud, Double pv_longitud) {
        this.pv_id = pv_id;
        this.pv_nombre = pv_nombre;
        this.pv_latitud = pv_latitud;
        this.pv_longitud = pv_longitud;
    }

    public Integer getPv_id() {
        return pv_id;
    }

    public void setPv_id(Integer pv_id) {
        this.pv_id = pv_id;
    }

    public String getPv_nombre() {
        return pv_nombre;
    }

    public void setPv_nombre(String pv_nombre) {
        this.pv_nombre = pv_nombre;
    }

    public Double getPv_latitud() {
        return pv_latitud;
    }

    public void setPv_latitud(Double pv_latitud) {
        this.pv_latitud = pv_latitud;
    }

    public Double getPv_longitud() {
        return pv_longitud;
    }

    public void setPv_longitud(Double pv_longitud) {
        this.pv_longitud = pv_longitud;
    }
}
