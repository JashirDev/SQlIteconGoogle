package com.example.gamer.puntosdeventas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.gamer.puntosdeventas.Adaptadores.ListaProductosAdapter;
import com.example.gamer.puntosdeventas.conexion.ConexionSQLiteHelper;
import com.example.gamer.puntosdeventas.entidades.Producto;
import com.example.gamer.puntosdeventas.entidades.PuntodeVenta;
import com.example.gamer.puntosdeventas.utilidades.Utilidades;

import java.util.ArrayList;

public class ListaProductoActivity extends AppCompatActivity {
    RecyclerView mirecicler;
    ArrayList<Producto>listaproducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_producto);
        mirecicler= (RecyclerView)findViewById(R.id.productoreciclador);
        mirecicler.setLayoutManager(new LinearLayoutManager(this));
         PuntodeVenta pv = null;
        Bundle objetoenviado = getIntent().getExtras();
        //PuntodeVenta pv = null;
        if (objetoenviado!=null){
            pv= (PuntodeVenta)objetoenviado.getSerializable("puntoventamapa");
            mostrar(pv);
        }
        ListaProductosAdapter adater= new ListaProductosAdapter(listaproducto);
        adater.setonclciklsitener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto producto = listaproducto.get(mirecicler.getChildAdapterPosition(v));
                Intent i = new Intent(ListaProductoActivity.this,ActualizarActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("producto",producto);
                startActivity(i);
            }
        });


        mirecicler.setAdapter(adater);
    }

    private void mostrar(PuntodeVenta pv) {

        listaproducto=new ArrayList<Producto>();
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this,
                "BD_USUARIO", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase() ;
       // Cursor fila =bd.rawQuery("SELECT * FROM "+ Utilidades.TABLA_PUNTOVENTA,null);
        Cursor fila=bd.rawQuery("SELECT "+Utilidades.CAMPO_ID_PRODUCTO
                +" , "+Utilidades.CAMPO_NOMBRE_PRODUCTO
                     //   +" , "+Utilidades.CAMPO_PV_LATITUD


                        +" FROM "+Utilidades.TABLA_DETALLE
                +" JOIN "+Utilidades.TABLA_PUNTOVENTA+" ON "+Utilidades.TABLA_PUNTOVENTA+"."+Utilidades.CAMPO_PV_ID+ " = "
                +Utilidades.TABLA_DETALLE+"."+Utilidades.CAMPO_DETA_IDPV
                + " JOIN "+Utilidades.TABLA_PRODUCTO+" ON "+Utilidades.TABLA_DETALLE+"."+Utilidades.CAMPO_DETA_IDPRO+" = "
                +Utilidades.TABLA_PRODUCTO+"."+Utilidades.CAMPO_ID_PRODUCTO
                +" WHERE "+Utilidades.TABLA_PUNTOVENTA+"."+Utilidades.CAMPO_PV_ID+" = "+pv.getPv_id()
                ,null);

        while(fila.moveToNext()){
       //     Log.e("ERROR"," "+fila.getString(0)+" "+fila.getString(1)+" "+fila.getString(2));
         //   Toast.makeText(this, "existe "+fila.getString(0)+" "+fila.getString(1),Toast.LENGTH_SHORT).show();
          Producto p= new Producto();
          p.setProducto_id(Integer.valueOf(fila.getString(0)));
          p.setProducto_nombre(fila.getString(1));

            listaproducto.add(p);
        }


    }
}
