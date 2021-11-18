package com.magit.mpi01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    TextView bievenidoLabel, continuarLabel, nuevoUsuario, olvidasteContarsena;
    ImageView loginImageView;
    TextInputLayout usuarioTextField, contrasenaTextField;
    MaterialButton inicioSesion;
    TextInputEditText emailEditText, passwordEditText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginImageView=findViewById(R.id.loginImageView);
        bievenidoLabel=findViewById(R.id.bienvenidoLabel);
        continuarLabel=findViewById(R.id.continuarLabe);
        usuarioTextField=findViewById(R.id.usuarioTextField);
        contrasenaTextField=findViewById(R.id.contrasenaTextField);
        inicioSesion=findViewById(R.id.inicioSesion);
        nuevoUsuario=findViewById(R.id.nuevoUsuario);
        emailEditText=findViewById(R.id.emailEditText);
        passwordEditText=findViewById(R.id.passwordEditText);
        olvidasteContarsena=findViewById(R.id.olvidasteContra);

        mAuth=FirebaseAuth.getInstance();

        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, SignUpActivity.class);

                Pair[] pairs = new Pair[7];
                pairs[0]=new Pair<View, String>(loginImageView, "logoImageTrans");
                pairs[1]=new Pair<View, String>(bievenidoLabel, "textTrans");
                pairs[2]=new Pair<View, String>(continuarLabel, "iniciaSesionTextTrans");
                pairs[3]=new Pair<View, String>(usuarioTextField, "emailInputTextTrans");
                pairs[4]=new Pair<View, String>(contrasenaTextField, "passwordInputTextTrans");
                pairs[5]=new Pair<View, String>(inicioSesion, "buttonSingInTrans");
                pairs[6]=new Pair<View, String>(nuevoUsuario, "newUserTrans");

                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        });

        olvidasteContarsena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPassword.class);

                Pair[] pairs = new Pair[3];
                pairs[0]=new Pair<View, String>(loginImageView, "logoImageTrans");
                pairs[1]=new Pair<View, String>(usuarioTextField, "emailImputTextTrans");
                pairs[2]=new Pair<View, String>(inicioSesion, "buttonSingInTrans");

                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }

            }
        });

        inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               validate();
            }
        });
    }

    public void validate() {
        String email=emailEditText.getText().toString().trim();
        String password=passwordEditText.getText().toString().trim();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Correo invalido");
            return;
        } else {
            emailEditText.setError(null);
        }

        if (password.isEmpty() || password.length()<8) {
            passwordEditText.setError("Se mecesitan mas de 8 caracteres");
        } else {
            passwordEditText.setError(null);
        }
        iniciarSesion(email, password);

    }

    public void iniciarSesion(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                           startActivity(intent);
                           finish();
                       } else {
                           Toast.makeText(LoginActivity.this, "Credenciales incorectas, intentalo de nuevo", Toast.LENGTH_LONG).show();
                           passwordEditText.setError("Contarseña Incorecta");
                       }
                    }
                });
    }


}