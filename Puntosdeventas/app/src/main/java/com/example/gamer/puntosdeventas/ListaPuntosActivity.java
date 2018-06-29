package com.example.gamer.puntosdeventas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamer.puntosdeventas.Adaptadores.ListaPuntosAdapter;
import com.example.gamer.puntosdeventas.conexion.ConexionSQLiteHelper;
import com.example.gamer.puntosdeventas.entidades.PuntodeVenta;
import com.example.gamer.puntosdeventas.utilidades.Utilidades;

import java.util.ArrayList;

public class ListaPuntosActivity extends AppCompatActivity {
    ArrayList<PuntodeVenta>lista;
    TextView tvid,nombre,lati,longi;
    RecyclerView mirecicler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_puntos);


        mirecicler=(RecyclerView)findViewById(R.id.reciclador);
        mirecicler.setLayoutManager(new LinearLayoutManager(this));

        mostrar();
        ListaPuntosAdapter adapter= new ListaPuntosAdapter(lista);
        adapter.setonclciklsitener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PuntodeVenta puntodeVenta = lista.get(mirecicler.getChildAdapterPosition(v));
                Intent intent = new Intent(ListaPuntosActivity.this,MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("puntoventa",puntodeVenta);
                intent.putExtras(bundle);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"sellecion"+lista.get(mirecicler.getChildAdapterPosition(v)).getPv_nombre(),Toast.LENGTH_SHORT).show();
            }
        });
        mirecicler.setAdapter(adapter);
    }

    private void mostrar() {
        lista=new ArrayList<PuntodeVenta>();
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this,
                "BD_USUARIO", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase() ;
        Cursor fila =bd.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTOVENTA,null);
        while(fila.moveToNext()){
            PuntodeVenta p= new PuntodeVenta();
            p.setPv_id(Integer.parseInt(fila.getString(0)));
            p.setPv_nombre(fila.getString(1));
            p.setPv_latitud(Double.parseDouble(fila.getString(2)));
            p.setPv_longitud(Double.parseDouble(fila.getString(3)));
            lista.add(p);
        }

    }
}
