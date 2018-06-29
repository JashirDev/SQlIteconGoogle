package com.example.gamer.puntosdeventas.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gamer.puntosdeventas.R;
import com.example.gamer.puntosdeventas.entidades.PuntodeVenta;

import java.util.ArrayList;

public class ListaPuntosAdapter extends RecyclerView.Adapter<ListaPuntosAdapter.ListaPuntoViewHolder>
                implements View.OnClickListener{
    ArrayList<PuntodeVenta> milista;
    private  View.OnClickListener listener;

    public ListaPuntosAdapter(ArrayList<PuntodeVenta> milista) {
        this.milista = milista;
    }

    @Override
    public long getItemId(int position) {
        return milista.get(position).getPv_id();
    }

    @NonNull
    @Override
    public ListaPuntosAdapter.ListaPuntoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_listapunto,parent,false);
        v.setOnClickListener(this);
        return new ListaPuntoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPuntosAdapter.ListaPuntoViewHolder holder, int position) {
        holder.mid.setText(milista.get(position).getPv_id().toString());
        holder.nombre.setText(milista.get(position).getPv_nombre());

    }

    @Override
    public int getItemCount() {
        return milista.size();
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

    public class ListaPuntoViewHolder extends RecyclerView.ViewHolder {
        TextView mid, nombre;
        public ListaPuntoViewHolder(View v) {
            super(v);
            mid= v.findViewById(R.id.card_id);
            nombre= v.findViewById(R.id.card_nombre);

        }
    }
}
