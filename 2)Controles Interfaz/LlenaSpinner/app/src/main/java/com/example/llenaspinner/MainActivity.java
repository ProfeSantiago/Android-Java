package com.example.llenaspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner miSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = (Spinner) findViewById(R.id.miSpinner);

        List<String> listaCiudades = new ArrayList<>();

        listaCiudades.add("Tangamandapio");
        listaCiudades.add("Ciudad Gótica");
        listaCiudades.add("Narnia");
        listaCiudades.add("Nunca Jamás");
        listaCiudades.add("Kronos");
        listaCiudades.add("Nabú");
        listaCiudades.add("El Dorado");
        listaCiudades.add("Ciudad AutoBot");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listaCiudades);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        miSpinner.setAdapter(dataAdapter);
    }
}
