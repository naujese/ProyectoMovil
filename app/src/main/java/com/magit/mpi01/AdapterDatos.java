package com.magit.mpi01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<DatosVo> listaDatos;

    public AdapterDatos(ArrayList<DatosVo> listaDatos) {
        this.listaDatos = listaDatos;
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
        }
    }
}
