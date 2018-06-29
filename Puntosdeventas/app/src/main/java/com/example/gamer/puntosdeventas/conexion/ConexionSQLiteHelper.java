package com.example.gamer.puntosdeventas.conexion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gamer.puntosdeventas.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
    datosusuarios(db);
    db.execSQL(Utilidades.CREAR_TABLA_PUNTOVENTA);
    datosPuntos(db);
    db.execSQL(Utilidades.CREAR_TABLA_PRODUCTO);
    datosProducto(db);
    db.execSQL(Utilidades.CREAR_TABLA_DETALLE);
    datosDetalle(db);



    }

    private void datosDetalle(SQLiteDatabase midb) {

        ContentValues insert1 = new ContentValues();
        insert1.put(Utilidades.CAMPO_DETA_ID,1);
        insert1.put(Utilidades.CAMPO_DETA_CANTIDAD,20);
        insert1.put(Utilidades.CAMPO_DETA_IDPV,1);
        insert1.put(Utilidades.CAMPO_DETA_IDPRO,1);
        midb.insert(Utilidades.TABLA_DETALLE,null,insert1);

        ContentValues insert2 = new ContentValues();
        insert2.put(Utilidades.CAMPO_DETA_ID,2);
        insert2.put(Utilidades.CAMPO_DETA_CANTIDAD,10);
        insert2.put(Utilidades.CAMPO_DETA_IDPV,1);
        insert2.put(Utilidades.CAMPO_DETA_IDPRO,3);
        midb.insert(Utilidades.TABLA_DETALLE,null,insert2);

        ContentValues insert3 = new ContentValues();
        insert3.put(Utilidades.CAMPO_DETA_ID,3);
        insert3.put(Utilidades.CAMPO_DETA_CANTIDAD,5);
        insert3.put(Utilidades.CAMPO_DETA_IDPV,2);
        insert3.put(Utilidades.CAMPO_DETA_IDPRO,5);
        midb.insert(Utilidades.TABLA_DETALLE,null,insert3);

        ContentValues insert4 = new ContentValues();
        insert4.put(Utilidades.CAMPO_DETA_ID,4);
        insert4.put(Utilidades.CAMPO_DETA_CANTIDAD,30);
        insert4.put(Utilidades.CAMPO_DETA_IDPV,3);
        insert4.put(Utilidades.CAMPO_DETA_IDPRO,4);
        midb.insert(Utilidades.TABLA_DETALLE,null,insert4);

        ContentValues insert5 = new ContentValues();
        insert5.put(Utilidades.CAMPO_DETA_ID,1);
        insert5.put(Utilidades.CAMPO_DETA_CANTIDAD,12);
        insert5.put(Utilidades.CAMPO_DETA_IDPV,3);
        insert5.put(Utilidades.CAMPO_DETA_IDPRO,1);
        midb.insert(Utilidades.TABLA_DETALLE,null,insert5);

        ContentValues insert6 = new ContentValues();
        insert6.put(Utilidades.CAMPO_DETA_ID,6);
        insert6.put(Utilidades.CAMPO_DETA_CANTIDAD,8);
        insert6.put(Utilidades.CAMPO_DETA_IDPV,2);
        insert6.put(Utilidades.CAMPO_DETA_IDPRO,1);
        midb.insert(Utilidades.TABLA_DETALLE,null,insert6);
    }

    private void datosProducto(SQLiteDatabase midb) {
        ContentValues insert1 = new ContentValues();
        insert1.put(Utilidades.CAMPO_ID_PRODUCTO,1);
        insert1.put(Utilidades.CAMPO_NOMBRE_PRODUCTO,"Lacteos");
        midb.insert(Utilidades.TABLA_PRODUCTO,null,insert1);

        ContentValues insert2 = new ContentValues();
        insert2.put(Utilidades.CAMPO_ID_PRODUCTO,2);
        insert2.put(Utilidades.CAMPO_NOMBRE_PRODUCTO,"Galletas");
        midb.insert(Utilidades.TABLA_PRODUCTO,null,insert2);

        ContentValues insert3 = new ContentValues();
        insert3.put(Utilidades.CAMPO_ID_PRODUCTO,3);
        insert3.put(Utilidades.CAMPO_NOMBRE_PRODUCTO,"Gaseosas");
        midb.insert(Utilidades.TABLA_PRODUCTO,null,insert3);

        ContentValues insert4 = new ContentValues();
        insert4.put(Utilidades.CAMPO_ID_PRODUCTO,4);
        insert4.put(Utilidades.CAMPO_NOMBRE_PRODUCTO,"Agua Mineral");
        midb.insert(Utilidades.TABLA_PRODUCTO,null,insert4);

        ContentValues insert5 = new ContentValues();
        insert5.put(Utilidades.CAMPO_ID_PRODUCTO,5);
        insert5.put(Utilidades.CAMPO_NOMBRE_PRODUCTO,"Golosinas");
        midb.insert(Utilidades.TABLA_PRODUCTO,null,insert5);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usuario");
        db.execSQL("create table usuario (idUsuario integer primary key, usuario text, contrasenha text)");
    }


    private void datosusuarios(SQLiteDatabase midb) {
        ContentValues insert1 = new ContentValues();
        insert1.put(Utilidades.CAMPO_ID,1);
        insert1.put(Utilidades.CAMPO_NOMBRE,"admin");
        insert1.put(Utilidades.CAMPO_PASS,"admin");
        midb.insert(Utilidades.TABLA_USUARIO,null,insert1);

        ContentValues insert2 = new ContentValues();
        insert2.put(Utilidades.CAMPO_ID,2);
        insert2.put(Utilidades.CAMPO_NOMBRE,"juan");
        insert2.put(Utilidades.CAMPO_PASS,"123");
        midb.insert(Utilidades.TABLA_USUARIO,null,insert2);

        ContentValues insert3 = new ContentValues();
        insert3.put(Utilidades.CAMPO_ID,3);
        insert3.put(Utilidades.CAMPO_NOMBRE,"luis");
        insert3.put(Utilidades.CAMPO_PASS,"l123");
        midb.insert(Utilidades.TABLA_USUARIO,null,insert3);
    }

    private void datosPuntos(SQLiteDatabase midb) {
        ContentValues insert1 = new ContentValues();
        insert1.put(Utilidades.CAMPO_PV_ID,1);
        insert1.put(Utilidades.CAMPO_PV_NOMBRE,"Choza NAutica");
        insert1.put(Utilidades.CAMPO_PV_LATITUD,-11.991175 );
        insert1.put(Utilidades.CAMPO_PV_LONGITUD,-77.080003);
        midb.insert(Utilidades.TABLA_PUNTOVENTA,null,insert1);

        ContentValues insert2 = new ContentValues();
        insert2.put(Utilidades.CAMPO_PV_ID,2);
        insert2.put(Utilidades.CAMPO_PV_NOMBRE,"TEPSA");
        insert2.put(Utilidades.CAMPO_PV_LATITUD,-11.991941  );
        insert2.put(Utilidades.CAMPO_PV_LONGITUD,-77.074907);
        midb.insert(Utilidades.TABLA_PUNTOVENTA,null,insert2);

        ContentValues insert3 = new ContentValues();
        insert3.put(Utilidades.CAMPO_PV_ID,3);
        insert3.put(Utilidades.CAMPO_PV_NOMBRE,"La vaca");
        insert3.put(Utilidades.CAMPO_PV_LATITUD,-11.991626);
        insert3.put(Utilidades.CAMPO_PV_LONGITUD,-77.072847);
        midb.insert(Utilidades.TABLA_PUNTOVENTA,null,insert3);
    }
}
