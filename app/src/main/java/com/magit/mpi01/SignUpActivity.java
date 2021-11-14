package com.magit.mpi01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    TextView nuevoUsuario, bievenidoLabel, continuarLabel;
    ImageView signUpImageView;
    TextInputLayout usuarioSingUpTextField, contrasenaTextField;
    MaterialButton inicioSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpImageView=findViewById(R.id.singUpImageView);
        bievenidoLabel=findViewById(R.id.bienvenidoLabel);
        continuarLabel=findViewById(R.id.continuarLabe);
        usuarioSingUpTextField=findViewById(R.id.usuarioSignUPTextField);
        contrasenaTextField=findViewById(R.id.contrasenaTextField);
        inicioSesion=findViewById(R.id.inicioSesion);
        nuevoUsuario=findViewById(R.id.nuevoUsuario);

        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionBack();
            }
        });

    }

    @Override
    public void onBackPressed(){
        transitionBack();
    }

    public void transitionBack(){
        Intent intent=new Intent(SignUpActivity.this, LoginActivity.class);

        Pair[] pairs = new Pair[7];
        pairs[0]=new Pair<View, String>(signUpImageView, "logoImageTrans");
        pairs[1]=new Pair<View, String>(bievenidoLabel, "textTrans");
        pairs[2]=new Pair<View, String>(continuarLabel, "iniciaSesionTextTrans");
        pairs[3]=new Pair<View, String>(usuarioSingUpTextField, "emailInputTextTrans");
        pairs[4]=new Pair<View, String>(contrasenaTextField, "passwordInputTextTrans");
        pairs[5]=new Pair<View, String>(inicioSesion, "buttonSingInTrans");
        pairs[6]=new Pair<View, String>(nuevoUsuario, "newUserTrans");

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
            finish();
        }
    }
}