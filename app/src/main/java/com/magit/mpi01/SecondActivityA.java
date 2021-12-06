package com.magit.mpi01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivityA extends AppCompatActivity {

    CardView uno;
    CardView dos;
    CardView tres;
    CardView cuatro;
    CardView cinco;
    CardView seis;
    CardView ciete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        uno=findViewById(R.id.uno);
        dos=findViewById(R.id.dos);
        tres=findViewById(R.id.tres);
        cuatro=findViewById(R.id.cuatro);
        cinco=findViewById(R.id.cinco);
        seis=findViewById(R.id.seis);
        ciete=findViewById(R.id.ciete);

        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SecondActivityA.this, ThirdActivityAA.class);
                startActivity(intent);
            }
        });

        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SecondActivityA.this, ThirdActivityAB.class);
                startActivity(intent);
            }
        });

        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SecondActivityA.this, ThirdActivityAC.class);
                startActivity(intent);
            }
        });

        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SecondActivityA.this, ThirdActivityAD.class);
                startActivity(intent);
            }
        });

        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SecondActivityA.this, ThirdActivityAE.class);
                startActivity(intent);
            }
        });

        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SecondActivityA.this, ThirdActivityAF.class);
                startActivity(intent);
            }
        });

        ciete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SecondActivityA.this, ThirdActivityAG.class);
                startActivity(intent);
            }
        });

    }
}