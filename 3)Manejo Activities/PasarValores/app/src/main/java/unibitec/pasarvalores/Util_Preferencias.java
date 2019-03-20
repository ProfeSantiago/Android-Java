package unibitec.pasarvalores;

import android.content.Context;
import android.content.SharedPreferences;

public class Util_Preferencias {

    Context miContexto;
    private SharedPreferences PrefereciasConfiguracion;
    private SharedPreferences.Editor editorPrefConfig;

    public Util_Preferencias(Context elContexto){
        miContexto= elContexto;
        PrefereciasConfiguracion = miContexto.getSharedPreferences("PrefConfig", miContexto.MODE_PRIVATE);
        editorPrefConfig = PrefereciasConfiguracion.edit();
    }//Fin Constructor #1  =======================

    public Util_Preferencias(){} //Fin Constructor #2

    public void GuardaPrefConfig(String laIP){
        editorPrefConfig.putString("laIP", laIP);
        editorPrefConfig.commit();
    }//Fin GuardaPrefConfig =======================

    public String CargaPref_Configuracion(){
        String laIP ="";

        //Cargamos las referencias Creadas/Enviadas
        SharedPreferences prefs = miContexto.getSharedPreferences("PrefConfig", miContexto.MODE_PRIVATE);
        laIP = prefs.getString("laIP", "0,0,0,0");

        return laIP;
    }//Fin CargaPref_Configuracion =======================

}//Fin Util_Preferencias
