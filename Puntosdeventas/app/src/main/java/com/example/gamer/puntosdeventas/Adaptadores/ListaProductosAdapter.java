package com.example.gamer.puntosdeventas.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gamer.puntosdeventas.R;
import com.example.gamer.puntosdeventas.entidades.Producto;

import java.util.ArrayList;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.ProductoViewHolder>
        implements View.OnClickListener{

    ArrayList<Producto>listaproducto;
    private  View.OnClickListener listener;

    public ListaProductosAdapter(ArrayList<Producto> listaproducto) {
        this.listaproducto = listaproducto;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_listaproducto,parent,false);
        v.setOnClickListener(this);
        return new ProductoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.texto.setText(listaproducto.get(position).getProducto_id().toString());
        holder.prnombre.setText(listaproducto.get(position).getProducto_nombre());
    }

    @Override
    public int getItemCount() {
        return listaproducto.size();
    }

    public void setonclciklsitener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView texto, prnombre;
        public ProductoViewHolder(View itemView) {
            super(itemView);
            texto= itemView.findViewById(R.id.card_producto_id);
            prnombre= itemView.findViewById(R.id.card_producto_nombre);
        }
    }
}
