package com.example.gamer.puntosdeventas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gamer.puntosdeventas.conexion.ConexionSQLiteHelper;
import com.example.gamer.puntosdeventas.entidades.Producto;
import com.example.gamer.puntosdeventas.entidades.PuntodeVenta;
import com.example.gamer.puntosdeventas.utilidades.Utilidades;

public class ActualizarActivity extends AppCompatActivity {

    TextInputLayout laya;
    TextInputEditText inputcantidad;
    TextView actid, cantidad;
    Button btactualizar,btguardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        actid=findViewById(R.id.tv_idDetalle);
        cantidad=findViewById(R.id.tvc_cantidad);
        btactualizar= findViewById(R.id.btactualizarcantiadad);
        btguardar= findViewById(R.id.btcantidad_guadar);
        laya= findViewById(R.id.inpulayput);
        inputcantidad=findViewById(R.id.inpCantidad);

        Producto pro = null;
        Bundle objetoenviado = getIntent().getExtras();
        //PuntodeVenta pv = null;
        if (objetoenviado!=null){
            pro= (Producto) objetoenviado.getSerializable("producto");
            mostrarproducto(pro);
        }
    }

    private void mostrarproducto(Producto pro) {
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this,
                "BD_USUARIO", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase() ;

        Cursor fila=bd.rawQuery("SELECT "+ Utilidades.CAMPO_DETA_ID
                        +" , "+Utilidades.CAMPO_DETA_CANTIDAD
                        +" FROM "+Utilidades.TABLA_DETALLE
                        +" JOIN "+Utilidades.TABLA_PUNTOVENTA+" ON "+Utilidades.TABLA_PUNTOVENTA+"."+Utilidades.CAMPO_PV_ID+ " = "
                        +Utilidades.TABLA_DETALLE+"."+Utilidades.CAMPO_DETA_IDPV
                        + " JOIN "+Utilidades.TABLA_PRODUCTO+" ON "+Utilidades.TABLA_DETALLE+"."+Utilidades.CAMPO_DETA_IDPRO+" = "
                        +Utilidades.TABLA_PRODUCTO+"."+Utilidades.CAMPO_ID_PRODUCTO
                        +" WHERE "+Utilidades.TABLA_PUNTOVENTA+"."+Utilidades.CAMPO_PV_ID+" = "+pro.getProducto_id()
                ,null);

    }

    public void mostrarcampo(View view) {
        laya.setVisibility(view.VISIBLE);
        inputcantidad.setVisibility(view.VISIBLE);

    }
}
