package com.example.santirodriguez.ventanas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ventana1 extends Activity implements View.OnClickListener {

    Button BotonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana1);

        incializaPantalla();
    }

    public void incializaPantalla() {
        BotonVolver = (Button) findViewById(R.id.button3);
        BotonVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button3:
                startActivity(new Intent(Ventana1.this, Principal.class));
                break;
        }//End switch
    }//onClick
}
