package com.example.santirodriguez.rellenalistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class RellenaListView extends Activity implements View.OnClickListener  {

    ListView ListaLenguajes;

    ArrayAdapter<String> adaptador;

    Button AgregaBtn;

    /*Este arreglo contiene los textos de las opciones mostradas en el listbox*/
    String[] ArregloLenguajes = new String[] { "Android", "Java" , "PHP", "C++"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rellena_list_view);

        //Inicializamos y Cargamos el Boton
        AgregaBtn = (Button) findViewById(R.id.Agrega_Btn);
        AgregaBtn.setOnClickListener(this);

        //Inicializamos y Cargamos el ListView
        ListaLenguajes = (ListView) findViewById(R.id.miListView);

        ListaLenguajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int laPosicion = position + 1;
                String elementoSeleccionado =
                        (String) ListaLenguajes.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Seleccionaste el item: " +
                        laPosicion + ") " +
                        elementoSeleccionado, Toast.LENGTH_LONG).show();
            }
        });//End setOnItemClickListener

        //Rellenamos el ListView con el Arreglo
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                ArregloLenguajes);
        ListaLenguajes.setAdapter(adaptador);

    }//End onCreate ----------------------------------------------

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.Agrega_Btn:
                //Agregamos o modificamos un elemento al Arreglo y al ListView

                ArregloLenguajes[0] = "C#";
                adaptador.notifyDataSetChanged();

                break;
        }//End switch
    }//Fin onClick =======================

 }
