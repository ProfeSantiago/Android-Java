package unibitec.pasarvalores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

public class Ventana1 extends AppCompatActivity {

    String elMensaje = "";

    Util_Preferencias UtilPreferencias; //Instancia de nuestra clase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Iniciamos la instancia de nuestra clase
        UtilPreferencias = new Util_Preferencias(getApplicationContext());

        //Cargamos las referencias guardadas
        elMensaje =UtilPreferencias.CargaPref_Configuracion();

        Toast miVarToast = Toast.makeText(getApplicationContext(), "Valor de preferencias: " + elMensaje, Toast.LENGTH_LONG);
        miVarToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        miVarToast.show();

        //==========================================================

        Bundle losExtras = getIntent().getExtras();
        if (losExtras != null) {
            elMensaje = losExtras.getString("elValor");
        }
        Toast.makeText(Ventana1.this, "Valor del Extra: " + elMensaje, Toast.LENGTH_LONG).show();

    }

}
