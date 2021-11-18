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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    MaterialButton recuperarBoton;
    TextInputEditText emailEditText;
    ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        recuperarBoton=findViewById(R.id.recuperarBoton);
        emailEditText=findViewById(R.id.emailEditText);
        logoImageView=findViewById(R.id.logoImageView);

        recuperarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    public void validate() {
        String email=emailEditText.getText().toString().trim();
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Correo Invalido");
            return;
        }
        sendEmail(email);
    }



    public void sendEmail(String email) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = email;

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                       if (task.isSuccessful()) {
                           Toast.makeText(ForgotPassword.this, "Correo enviado. Verifique su bandeja de entrada", Toast.LENGTH_LONG).show();
                           Intent intent = new Intent(ForgotPassword.this, LoginActivity.class);
                           Pair[] pairs = new Pair[2];
                           pairs[0]=new Pair<View, String>(emailEditText, "emailInputTextTrans");
                           pairs[1]=new Pair<View, String>(recuperarBoton, "buttonSingInTrans");

                           if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                               ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(ForgotPassword.this, pairs);
                               startActivity(intent, options.toBundle());
                           } else {
                               startActivity(intent);
                               finish();
                           }
                       } else {
                           Toast.makeText(ForgotPassword.this, "correo invalido", Toast.LENGTH_SHORT).show();

                       }
                    }
                });
    }

    @Override
    public void onBackPressed(){
        transitionBack();
    }

    public void transitionBack(){
        Intent intent=new Intent(ForgotPassword.this, LoginActivity.class);

        Pair[] pairs = new Pair[2];
        pairs[0]=new Pair<View, String>(emailEditText, "emailInputTextTrans");
        pairs[1]=new Pair<View, String>(recuperarBoton, "buttonSingInTrans");

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(ForgotPassword.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
            finish();
        }
    }
}