package com.example.universidad.webapis;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebApiActivity extends Activity implements View.OnClickListener  {

    //Clase para mostrar Toast
    Util_UI_Class UtilesUI = new Util_UI_Class();
    Button LlamaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_api);

        //Inicializamos el Boton
        LlamaBtn = (Button) findViewById(R.id.LlamaBtn);
        LlamaBtn.setOnClickListener(this);
    }//Fin onCreate =======================

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.LlamaBtn:
                //Creamos una instancia de la clase: miTarea y la ejecutamos
                miTarea laTarea = new miTarea();
                laTarea.execute();
                break;
        }//End switch
    }//Fin onClick =======================

    private class miTarea extends AsyncTask<Void, Void, Void> {
        String UrlTxt  = "https://jsonip.com/";
        String elTextoBuffer;
        String elTextoFinal="";

        @Override
        protected Void doInBackground(Void... params){
            URL elUrl;
            try{
                //Nos conectamos y leemos del Servicio Web
                elUrl = new URL(UrlTxt);
                BufferedReader elBufferReader = new BufferedReader(new InputStreamReader(elUrl.openStream()));

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
                JSONObject clienteJSON =  new JSONObject(new String(elTextoFinal));

                //Mostramos un valor del JSON
                UtilesUI.MensajeToast(getApplicationContext(),"La ip es: "+ clienteJSON.getString("ip"));

                //-----------------------------------------------------------------
                //En el caso de que sean muchos datos
                /*
                JSONArray elJSONArray = new JSONArray(new String(elTextoFinal));

                for(int i=0; i<elJSONArray.length() ;i++) {
                    JSONObject elJSON = elJSONArray.getJSONObject(i);
                    UtilesUI.MensajeToast(getApplicationContext(),
                            "La ip es: " + elJSON.getString("ip"));
                }//End For
                */
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
