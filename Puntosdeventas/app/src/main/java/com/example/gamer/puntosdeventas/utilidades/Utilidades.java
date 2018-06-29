package com.example.gamer.puntosdeventas.utilidades;

public class Utilidades {

    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_PASS="password";

    //crear tabla ususario
    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_ID+" " +
            "INTEGER PRIMARY KEY, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_PASS+" TEXT)";


    //Constantes campo Producto
    public static final String TABLA_PRODUCTO="producto";
    public static final String CAMPO_ID_PRODUCTO="producto_id";
    public static final String CAMPO_NOMBRE_PRODUCTO="producto_nombre";

    //crear tabla producto
    public static final String CREAR_TABLA_PRODUCTO="CREATE TABLE " +
            ""+TABLA_PRODUCTO+" ("+CAMPO_ID_PRODUCTO+" " +
            "INTEGER PRIMARY KEY, "+CAMPO_NOMBRE_PRODUCTO+" TEXT)";

    //Constantes campo puntodeventa
    public static final String TABLA_PUNTOVENTA="puntoventa";
    public static final String CAMPO_PV_ID="pv_id";
    public static final String CAMPO_PV_NOMBRE="pv_nombre";
    public static final String CAMPO_PV_LATITUD="pv_latitud";
    public static final String CAMPO_PV_LONGITUD="pv_longitud";

    //crear tabla puntoventa
    public static final String CREAR_TABLA_PUNTOVENTA="CREATE TABLE " +
            ""+TABLA_PUNTOVENTA+" ("+CAMPO_PV_ID+" " +
            "INTEGER PRIMARY KEY, "+CAMPO_PV_NOMBRE+" TEXT, "+ CAMPO_PV_LATITUD+" DECIMAL(8,6), "+CAMPO_PV_LONGITUD+" DECIMAL(8,6))";



    //Constantes campo puntodeventa
    public static final String TABLA_DETALLE="detalle";
    public static final String CAMPO_DETA_ID="deta_id";
    public static final String CAMPO_DETA_CANTIDAD="deta_cantidad";
    public static final String CAMPO_DETA_IDPV="deta_pv_id";
    public static final String CAMPO_DETA_IDPRO="deta_producto_id";

    public static final String CREAR_TABLA_DETALLE="CREATE TABLE " +
            ""+TABLA_DETALLE+" ("+CAMPO_DETA_ID+" " +
            "INTEGER PRIMARY KEY, "+CAMPO_DETA_CANTIDAD+" INTEGER, "+ CAMPO_DETA_IDPV+" INTEGER, "
            +CAMPO_DETA_IDPRO+" INTEGER, FOREIGN KEY("+CAMPO_DETA_IDPV+") REFERENCES "+TABLA_PUNTOVENTA+"("+CAMPO_PV_ID+"), "
            +"FOREIGN KEY("+CAMPO_DETA_IDPRO+") REFERENCES "+TABLA_PRODUCTO+"("+CAMPO_ID_PRODUCTO+")"
            +")";



}
