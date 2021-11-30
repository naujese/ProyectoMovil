package com.magit.mpi01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements AdapterDatos.lugarSelecionado {

    ArrayList<DatosVo> antiguo;
    RecyclerView rcAntiguo;
    ArrayList<DatosVo> moderno;
    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        antiguo=new ArrayList<>();
        moderno=new ArrayList<>();
        rcAntiguo=findViewById(R.id.recyclerId);
        titulo=findViewById(R.id.titleTextView);
        rcAntiguo.setLayoutManager(new LinearLayoutManager(this));

        cargarLista();






    }

    private void cargarLista() {
        Bundle datosExtra=getIntent().getExtras();
        String identificador=datosExtra.getString("id");

        if (identificador.equals("Maravillas del mundo antiguo")) {
            llenarAntiguo();
            AdapterDatos adapter=new AdapterDatos(antiguo, this);
            rcAntiguo.setAdapter(adapter);
            titulo.setText("Maravillas del mundo antiguo");
        }
        if (identificador.equals("Maravillas del mundo moderno")) {
            llenarModerno();
            AdapterDatos adapter = new AdapterDatos(moderno, this);
            rcAntiguo.setAdapter(adapter);
            titulo.setText("Maravillas del mundo moderno");
        }
    }

    private void llenarAntiguo() {
        antiguo.add(new DatosVo("Piramides de Giza","egipto",R.drawable.ic_piramides));

    }

    private void llenarModerno() {
        moderno.add(new DatosVo("Taj mahal","India",R.drawable.ic_taj));
        moderno.add(new DatosVo("Petra","Jordania",R.drawable.ic_petra));
        moderno.add(new DatosVo("La Gran Muralla china","China",R.drawable.ic_muralla));
        moderno.add(new DatosVo("Chichén Itzá","México",R.drawable.ic_chitzen));
        moderno.add(new DatosVo("Machu Picchu","Perú",R.drawable.ic_machu));
        moderno.add(new DatosVo("Coliseo Romano","Italia",R.drawable.ic_coliseo));
        moderno.add(new DatosVo("El Cristo Redentor","Brasil",R.drawable.ic_cristo));

    }

    @Override
    public void lugarSelecionado(DatosVo datosVo) {

    }
}