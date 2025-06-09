package com.alexo.desarrollomovilfase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListAllSensorsActivity extends AppCompatActivity {
    Button MostrarTexto;
    Button btnEnlistar;
    TextView tvSensores;
    RecyclerView rvSensores;
    List<Sensor> ListaSensores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_sensors);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        ListaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        tvSensores = (TextView) findViewById(R.id.txtViewAllSensors);
        rvSensores = (RecyclerView) findViewById(R.id.rvSensorsAll);
        btnEnlistar = (Button) findViewById(R.id.btnListarSensorsAll);

        Sensor sensorProximidad = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        MostrarTexto = (Button) findViewById(R.id.btnShowSensorsAll);
        MostrarTexto.setOnClickListener(mostrarSensores());

    }

    private View.OnClickListener mostrarSensores() {
        return v -> {
            tvSensores.setText(ListaSensores.toString());
            tvSensores.setVisibility(View.VISIBLE);
            rvSensores.setVisibility(View.INVISIBLE);

            tvSensores.setMovementMethod(new ScrollingMovementMethod());
        };
    }
}