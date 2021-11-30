package com.magit.mpi01;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment implements AdapterDatos.lugarSelecionado{


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    RecyclerView recyclerDatos;
    ArrayList<DatosVo> listaDatos;

    public SecondFragment() {

    }

    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_second, container, false);
        listaDatos=new ArrayList<>();
        recyclerDatos=(RecyclerView) vista.findViewById(R.id.recyclerId);
        recyclerDatos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();
        AdapterDatos adapter=new AdapterDatos(listaDatos, this);
        recyclerDatos.setAdapter(adapter);
        return vista;

    }

    private void llenarLista() {
        listaDatos.add(new DatosVo("Maravillas del mundo antiguo","egipto",R.drawable.ic_piramides));
        listaDatos.add(new DatosVo("Maravillas del mundo moderno","asia",R.drawable.ic_taj));
    }


    @Override
    public void lugarSelecionado(DatosVo datosVo) {
        Intent intent=new Intent(getActivity(), SecondActivity.class);
        intent.putExtra("id",datosVo.getTitulo());
        startActivity(intent);


    }
}