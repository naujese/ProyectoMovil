package com.magit.mpi01;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<DatosVo> listaDatos;
    private View.OnClickListener listener;
    private lugarSelecionado lugarSelecionado;

    public AdapterDatos(ArrayList<DatosVo> listaDatos, lugarSelecionado lugarSelecionado ) {
        this.listaDatos = listaDatos;
        this.lugarSelecionado= lugarSelecionado;
    }


    @Override
    public ViewHolderDatos onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_element,null,false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder( ViewHolderDatos holder, int position) {
        holder.etiTitulo.setText(listaDatos.get(position).getTitulo());
        holder.etiInfo.setText(listaDatos.get(position).getInfo());
        holder.foto.setImageResource(listaDatos.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        ImageView foto;
        TextView etiTitulo, etiInfo;


        public ViewHolderDatos( View itemView) {
            super(itemView);
            foto=(ImageView) itemView.findViewById(R.id.idFoto);
            etiTitulo=(TextView) itemView.findViewById(R.id.idTitulo);
            etiInfo=(TextView) itemView.findViewById(R.id.idInfo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lugarSelecionado.lugarSelecionado(listaDatos.get(getAdapterPosition()));
                }
            });

        }
    }

    public interface lugarSelecionado{
        void lugarSelecionado(DatosVo datosVo);
    }
}
