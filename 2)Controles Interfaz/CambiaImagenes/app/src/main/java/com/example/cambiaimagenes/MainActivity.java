package com.example.cambiaimagenes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView CambiaImagen;
    Button BotoCambiador;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BotoCambiador = (Button)findViewById(R.id.button);
        CambiaImagen = (ImageView)findViewById(R.id.imageView);

        BotoCambiador.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (contador) {
                    case 0:
                        CambiaImagen.setImageResource(R.drawable.ahorcado1);
                        contador++;
                        break;
                    case 1:
                        CambiaImagen.setImageResource(R.drawable.ahorcado2);
                        contador++;
                        break;
                    case 2:
                        CambiaImagen.setImageResource(R.drawable.ahorcado3);
                        contador++;
                        break;
                    case 3:
                        CambiaImagen.setImageResource(R.drawable.ahorcado4);
                        contador++;
                        break;
                    case 4:
                        CambiaImagen.setImageResource(R.drawable.ahorcado5);
                        contador++;
                        break;
                    case 5:
                        CambiaImagen.setImageResource(R.drawable.ahorcado6);
                        contador++;
                        break;
                    case 6:
                        CambiaImagen.setImageResource(R.drawable.ahorcado0);
                        contador=0;
                        break;
                }
            }
        });
    }


}
