package com.example.santirodriguez.ejemplomenu;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class EjemploMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ejemplo_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_settings:
               Toast.makeText(getApplicationContext(),
                       "Seleccionaste la Configuración!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.accion_favoritos:
                Toast.makeText(getApplicationContext(),
                        "Seleccionaste los favoritos!", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(),
                        "Menú Desconocido!!...", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }//Fin onOptionsItemSelected ---------------------------------------------------------

}
