package com.example.universidad.basedatossqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal_Frm extends Activity implements View.OnClickListener {

    Button ProductosBtn;
    Button ClientesBtn;
    Button SalirBtn;
    Button SincronizaBtn;

    Util_UI UtilesUI = new Util_UI();
    CargaDatos_Class CargaDatosClass = new CargaDatos_Class(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal__frm);

        incializaPantalla();
    }

    private void incializaPantalla() {

        ProductosBtn = (Button) findViewById(R.id.ListaProductos_Btn);
        ClientesBtn = (Button) findViewById(R.id.ListaClientes_Btn);
        SalirBtn = (Button) findViewById(R.id.Salir_Btn);
        SincronizaBtn = (Button) findViewById(R.id.Sincroniza_Btn);
        ProductosBtn.setOnClickListener(this);
        ClientesBtn.setOnClickListener(this);
        SalirBtn.setOnClickListener(this);
        SincronizaBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.ListaClientes_Btn:
                startActivity(new Intent(Principal_Frm.this,Clientes_Frm.class));
                break;
            case R.id.ListaProductos_Btn:
                startActivity(new Intent(Principal_Frm.this, Articulos_Frm.class));
                break;
            case R.id.Sincroniza_Btn:
                UtilesUI.MensajeToast(getApplicationContext(), "Sincronizando..");
                CargaDatosClass.SincronizaTodo();
                break;
            case R.id.Salir_Btn:
                //UtilesUI.MensajeToast(getApplicationContext(), "Cerrando App..");
                Intent elIntent = new Intent(Intent.ACTION_MAIN);
                elIntent.addCategory(Intent.CATEGORY_HOME);
                elIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(elIntent);
                break;
        }//End switch
    }//onClick

}
