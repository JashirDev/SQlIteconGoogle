package com.example.gamer.puntosdeventas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gamer.puntosdeventas.conexion.ConexionSQLiteHelper;
import com.example.gamer.puntosdeventas.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText usuario;
    private TextInputEditText contra;
    private Button ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.usuario);
        contra = findViewById(R.id.password);
        ingresar = findViewById(R.id.btIngresar);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultaLogin(usuario.getText().toString(),contra.getText().toString());
            }
        });
    }

    public boolean consultaLogin(String user, String contra) {
        boolean result=false;
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this,
                "BD_USUARIO", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase() ;
        Cursor fila =bd.rawQuery(  "select "+ Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_PASS+" from "+Utilidades.TABLA_USUARIO+" where "+Utilidades.CAMPO_NOMBRE +"= '" + user+"'"+" and "+Utilidades.CAMPO_PASS+"= '"+contra+"'", null);


        if (fila.moveToFirst()) {
            result=true;
            Intent intent= new Intent(this,ListaPuntosActivity.class);
            startActivity(intent);
           // Toast.makeText(this, "existe usuario",Toast.LENGTH_SHORT).show();
        } else{
            result=false;
            Toast.makeText(this, "No existe usuario",
                    Toast.LENGTH_SHORT).show();}
        fila.close();
        bd.close();
        return result;
    }
}
