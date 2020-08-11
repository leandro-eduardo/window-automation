package com.eduardo.leandro.windowautomation.view;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.eduardo.leandro.windowautomation.R;
import com.eduardo.leandro.windowautomation.fragments.AboutFragment;
import com.eduardo.leandro.windowautomation.fragments.HistoryFragment;
import com.eduardo.leandro.windowautomation.fragments.HomeFragment;

public class AcelerometroActivity extends AppCompatActivity implements SensorEventListener {

    private final String TAG = "AcelerometroActivity";

    Sensor accelerometer;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);

        Log.i(TAG, "onCreate");

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Float sensorX = event.values[0];
        Float sensorY = event.values[1];
        Float sensorZ = event.values[2];

        /*
        Os valores oscilam de -10 a 10.
        Quanto maior o valor de X mais ele está caindo para a esquerda - Positivo Esqueda
        Quanto menor o valor de X mais ele está caindo para a direita  - Negativo Direita
        Se o valor de  X for 0 então o celular está em pé - Nem Direita Nem Esquerda
        Se o valor de Y for 0 então o celular está "deitado"
        Se o valor de Y for negativo então o celular está de cabeça pra baixo, então quanto menor Y mais ele está inclinando pra ir pra baixo
        Se o valor de Z for 0 então o dispositivo está reto na horizontal.
        Quanto maior o o valor de Z mais ele está inclinado para frente.
        Quanto menor o valor de Z mais ele esta inclinado para traz.
        */

        TextView tx = (TextView) findViewById(R.id.tX);
        TextView ty = (TextView) findViewById(R.id.tY);
        TextView tz = (TextView) findViewById(R.id.tZ);
        tx.setText("X: " + (sensorX));
        ty.setText("Y: " + (sensorY));
        tz.setText("Z: " + (sensorZ));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
