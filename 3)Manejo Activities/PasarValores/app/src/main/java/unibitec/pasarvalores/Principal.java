package unibitec.pasarvalores;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends Activity implements View.OnClickListener{

    Button BotonV1;
    Util_Preferencias UtilPreferencias; //Instancia de nuestra clase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Iniciamos la instancia de nuestra clase
        UtilPreferencias = new Util_Preferencias(getApplicationContext());

        BotonV1 = (Button) findViewById(R.id.button);
        BotonV1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                //Guardamos las Preferencias
                UtilPreferencias.GuardaPrefConfig("192.168.0.1");

                //Creamos un Intent para llamar el Activity
                Intent elIntent = new Intent(getApplicationContext(), Ventana1.class);
                //Le agregamos un "Extra"
                elIntent.putExtra("elValor", "Hola Muchachos");
                //Llamamos el Activity
                startActivity(elIntent);
                break;
        }//End switch
    }//onClick

}
