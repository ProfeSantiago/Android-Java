package com.example.santiago.impresorabluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.UUID;


public class Util_Print_Class extends Activity {

    public Util_Print_Class(Context context)
    {
        elContexto= context;
    }
    public Util_Print_Class(){}

    Context elContexto;
    BluetoothAdapter elBluetoothAdapter;
    UUID elDeviceID;
    BluetoothSocket elSocket;
    BluetoothDevice elDevice;
    OutputStream elFlujoSalida;

    public void CargaDevices(){
        Log.d("****>>", "CargaDevices");
        elBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

        if(elBluetoothAdapter != null){

            if (!elBluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(elBluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent,0 );
            }

            Set<BluetoothDevice> pairedDevices = elBluetoothAdapter.getBondedDevices();

             for(BluetoothDevice device : pairedDevices) {
                 if ((device.getName().equals("XXXXJ144502163")) || (device.getName().equals("XXXXJ144502099")) ){
                     elDevice = device;
                     elDeviceID = device.getUuids()[0].getUuid();
                     break;
                 }
             }//fin For
        }//Fin if
    }//Fin CargaDevices

    public void ConectaBlueTooth() {
        Log.d("****>>", "ConectaBlueTooth");
        try {
            CargaDevices();
            elSocket = elDevice.createRfcommSocketToServiceRecord(elDeviceID);
            elSocket.connect();
            elFlujoSalida = elSocket.getOutputStream();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//Fin ConectaBlueTooth

    private String ObtieneFecha(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }//Fin ObtieneFecha

    public void Imprime() throws IOException {
        Log.d("****>>", "Imprime");
        try {
            String ImprimeTxt = "----------------------------------------------";
            ImprimeTxt += "\n\r"+"Hoy es: "+ObtieneFecha();
            ImprimeTxt += "\n\r"+"...y acabas de imprimir con Android";
            ImprimeTxt += "\n\r"+"----------------------------------------------";
            elFlujoSalida.write(ImprimeTxt.getBytes());
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//Fin Imprime

   public void DesconectaBlueTooth(){
       Log.d("****>>", "DesconectaBlueTooth");
       try {
           if(elSocket!= null){
               elFlujoSalida.close();
               elSocket.close();
               elSocket = null;
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }//DesconectaBlueTooth

}//Fin Util_Print_Class
