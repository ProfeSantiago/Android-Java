package ulacit.libreriaredes;

import android.content.Context;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class Util_UI {

    public Util_UI(){}//Constructor de la clase

    public void MensajeToast(Context elContexto, String elTexto){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(elContexto, elTexto, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }//Fin MensajeToast =======================

    public ArrayAdapter CargaArrayAdapter(Context elContexto, ArrayList<String> ArregloLista){
        final ArrayAdapter elAdaptador;
        elAdaptador = new ArrayAdapter(elContexto, android.R.layout.simple_list_item_1, ArregloLista);
        return elAdaptador;
    }// Fin CargaListView =======================


}//Fin Util_UI
