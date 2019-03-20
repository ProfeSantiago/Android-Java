package com.example.ulacit.pruebascontroles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView MiLabel;
    Button MiBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MiLabel = (TextView) findViewById(R.id.miLabel);
        MiBoton = (Button) findViewById(R.id.MiBoton);

        MiBoton.setX(MiBoton.getX()+150);
        MiBoton.setY(MiBoton.getY()+100);

        MiLabel.setX(MiBoton.getX()+350);
        MiLabel.setY(MiBoton.getY()+300);

    }
}
