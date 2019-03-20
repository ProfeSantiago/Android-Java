package com.example.santi.webapis2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.MalformedJsonException;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    //Clase para mostrar Toast
    Util_UI_Class UtilesUI = new Util_UI_Class();
    Button LlamaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miTarea laTarea = new miTarea();
        laTarea.execute();
    }

    private class miTarea extends AsyncTask<Void, Void, Void> {
        String UrlTxt  = "https://jsonip.com/";
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
                UtilesUI.MensajeToast(getApplicationContext(), "Error al abrir el URL!");
                e.printStackTrace();
                Log.d("==>>Error: ", e.toString());
            }catch(IOException e){
                UtilesUI.MensajeToast(getApplicationContext(), "Error al cargar los datos!");
                e.printStackTrace();
                Log.d("==>>Error: ", e.toString());
            }
            return null;
        }//Fin doInBackground

        @Override
        protected void onPostExecute(Void result){
            try {
                //Guardamos los datos en un objeto JSON
               /*
                JSONObject clienteJSON =
                        new JSONObject(new String(elTextoFinal));


                //Mostramos un valor del JSON
                UtilesUI.MensajeToast(getApplicationContext(),
                        "La ip es: "+
                        clienteJSON.getString("ip"));
                */
                //-----------------------------------------------------------------
                //En el caso de que sean muchos datos

                JSONArray elJSONArray = new JSONArray(new String(elTextoFinal));

                for(int i=0; i<elJSONArray.length() ;i++) {
                    JSONObject elJSON = elJSONArray.getJSONObject(i);
					
                    UtilesUI.MensajeToast(getApplicationContext(),
                            "El pais es: " + elJSON.getString("name"));
                }//End For

                //-----------------------------------------------------------------

            } catch (JSONException e) {
                UtilesUI.MensajeToast(getApplicationContext(), "Error al mostrar los datos!");
                e.printStackTrace();
                Log.d("==>>Error: ", e.toString());
            }
            super.onPostExecute(result);

        }//Fin onPostExecute

    }//Fin miTarea =======================
}
