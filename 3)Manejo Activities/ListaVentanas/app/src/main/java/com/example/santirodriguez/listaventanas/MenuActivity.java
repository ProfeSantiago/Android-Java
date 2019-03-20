package com.example.santirodriguez.listaventanas;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MenuActivity extends ListActivity {

    /*Este Arreglo contiene los nombre de los Activities (Ventanas)*/
    String Ventanas[] = {"Ventana1","Ventana2"};

    /*Este arreglo contiene los textos de las opciones mostradas en el listbox*/
    String Opciones [] = {"Abre Ventana #1","Abre Ventana #2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListAdapter ListaMenu = new ArrayAdapter <String>
                (this, android.R.layout.simple_list_item_1, Opciones);

        setListAdapter(ListaMenu);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String nombreclase = Ventanas[position];
        Class AbrirClase;
        try {
            AbrirClase =
            Class.forName("com.example.santirodriguez.listaventanas."
            +nombreclase);

            Intent AbrirActivity = new Intent(this, AbrirClase);
            startActivity(AbrirActivity);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }//End catch*/
    }//End onListItemClick


}
