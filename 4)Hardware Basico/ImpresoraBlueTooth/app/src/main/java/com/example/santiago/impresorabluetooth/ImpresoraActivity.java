package com.example.santiago.impresorabluetooth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ImpresoraActivity extends Activity implements View.OnClickListener{

    Button ImprBtn;
    Util_Print_Class UtilPrint = new Util_Print_Class();
    Util_UI_Class UtilesUI = new Util_UI_Class();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impresora);

        ImprBtn = (Button) findViewById(R.id.ImprBtn);
        ImprBtn.setOnClickListener(this);

        UtilesUI.MensajeToast(getApplicationContext(), "Conectando con Impresora..");
        UtilPrint.ConectaBlueTooth();
    }//Fin onCreate =======================

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.ImprBtn:
                UtilesUI.MensajeToast(getApplicationContext(), "Imprimiendo..");
                try {
                    UtilPrint.Imprime();
                    UtilPrint.DesconectaBlueTooth();
                }  catch (Exception e) {}
                break;
        }//End switch
    }//Fin onClick =======================
}
