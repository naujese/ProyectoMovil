package com.magit.mpi01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class ThirdActivityBC extends AppCompatActivity implements SensorEventListener {

    private SensorManager sm;
    private Sensor s;
    private SensorEventListener evento;
    private int mod=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_bc);

        sm=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        if (x>9 && mod==0) {
            mod++;
        }

        if(mod==1){
            Intent intent= new Intent(ThirdActivityBC.this, FourthActivityBC.class);
            startActivity(intent);
            finish();
            mod=0;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }
}