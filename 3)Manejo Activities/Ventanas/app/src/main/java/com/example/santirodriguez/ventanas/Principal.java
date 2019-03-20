package com.example.santirodriguez.ventanas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends Activity implements View.OnClickListener {

    Button BotonV1;
    Button BotonV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        incializaPantalla();
    }

    public void incializaPantalla() {
        BotonV1 = (Button) findViewById(R.id.button);
        BotonV2 = (Button) findViewById(R.id.button2);

        BotonV1.setOnClickListener(this);
        BotonV2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                startActivity(new Intent(Principal.this, Ventana1.class));
                break;
            case R.id.button2:
                startActivity(new Intent(getApplicationContext(), Ventana2.class));
                break;
        }//End switch
    }//onClick

}
