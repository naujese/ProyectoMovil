package com.magit.mpi01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        new Handler().postDelayed(new  Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ConfirmationActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);


    }
}