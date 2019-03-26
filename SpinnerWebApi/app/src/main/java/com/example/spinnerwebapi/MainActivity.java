package com.example.spinnerwebapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;

import java.net.MalformedURLException;


public class MainActivity extends AppCompatActivity {

    Spinner miSpinner;
    List<String> listaCiudades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miTarea laTarea = new miTarea();
        laTarea.execute();

        miSpinner = (Spinner) findViewById(R.id.miSpinner);

        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCiudades);
        /*
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listaCiudades);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        */
        miSpinner.setAdapter(dataAdapter);
    }//Fin onCreate =======================

    public void MensajeToast(String elTexto){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), elTexto, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }//Fin MensajeToast =======================

    private class miTarea extends AsyncTask<Void, Void, Void> {
        String UrlTxt  = "https://restcountries.eu/rest/v2/all";
        String elTextoBuffer;
        String elTextoFinal="";

        @Override
        protected Void doInBackground(Void... params){
            URL elUrl;
            URLConnection Conexion = null;
            try{
                //Nos conectamos y leemos del Servicio Web
                elUrl = new URL(UrlTxt);
                Conexion = elUrl.openConnection();

                //Leemos el flujo completo de datos
                BufferedReader elBufferReader = new BufferedReader(new InputStreamReader(Conexion.getInputStream()));

                //Leemos linea por linea el contenido de lo leido
                while((elTextoBuffer = elBufferReader.readLine()) != null){
                    elTextoFinal += elTextoBuffer;
                }

                elBufferReader.close();//Cerramos el buffer

            }catch(MalformedURLException e){
                MensajeToast("Error al abrir el URL!");
                e.printStackTrace();
                Log.d("==>>Error: ", e.toString());
            }catch(IOException e){
                MensajeToast("Error al cargar los datos!");
                e.printStackTrace();
                Log.d("==>>Error: ", e.toString());
            }
            return null;
        }//Fin doInBackground

        @Override
        protected void onPostExecute(Void result){
            try {
                //Guardamos los datos en un objeto JSONArray

                JSONArray elJSONArray = new JSONArray(new String(elTextoFinal));

                for(int i=0; i<elJSONArray.length() ;i++) {
                    JSONObject elJSON = elJSONArray.getJSONObject(i);

                    listaCiudades.add(elJSON.getString("name"));

                }//End For

                //-----------------------------------------------------------------

            } catch (JSONException e) {
                MensajeToast("Error al mostrar los datos!");
                e.printStackTrace();
                Log.d("==>>Error: ", e.toString());
            }
            super.onPostExecute(result);

        }//Fin onPostExecute

    }//Fin miTarea =======================
}
