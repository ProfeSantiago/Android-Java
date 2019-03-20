package com.example.santirodriguez.ventanas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Ventana2 extends Activity implements View.OnClickListener {


    Button BotonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);

        incializaPantalla();
    }

    public void incializaPantalla() {
        BotonVolver = (Button) findViewById(R.id.button4);
        BotonVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button4:
                startActivity(new Intent(Ventana2.this, Principal.class));
                break;
        }//End switch
    }//onClick
}
