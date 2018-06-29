package com.example.gamer.puntosdeventas.entidades;

public class Detalle {
    private Integer det_id;
    private Integer det_catidad;
    private Integer deta_pv_id;
    private Integer deta_producto_id;

    public Detalle(Integer det_id, Integer det_catidad, Integer deta_producto_id, Integer deta_pv_id) {
        this.det_id = det_id;
        this.det_catidad = det_catidad;
        this.deta_producto_id = deta_producto_id;
        this.deta_pv_id = deta_pv_id;
    }

    public Integer getDet_id() {
        return det_id;
    }

    public void setDet_id(Integer det_id) {
        this.det_id = det_id;
    }

    public Integer getDet_catidad() {
        return det_catidad;
    }

    public void setDet_catidad(Integer det_catidad) {
        this.det_catidad = det_catidad;
    }

    public Integer getDeta_producto_id() {
        return deta_producto_id;
    }

    public void setDeta_producto_id(Integer deta_producto_id) {
        this.deta_producto_id = deta_producto_id;
    }

    public Integer getDeta_pv_id() {
        return deta_pv_id;
    }

    public void setDeta_pv_id(Integer deta_pv_id) {
        this.deta_pv_id = deta_pv_id;
    }
}
