package ulacit.libreriaredes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Util_Redes {

    Context miContexto;
    private static boolean conectadoWifi = false;
    private static boolean conectadoMobile = false;

    Util_UI UtilesUI = new Util_UI();  //Clase para mostrar Toast

    public Util_Redes(Context elContexto){
        miContexto= elContexto;
    }//Fin Constructor #1

    public Util_Redes(){} //Fin Constructor #2

    public boolean conectadoWifi(){//Devuelve true si esta conectado al Wifi
        try {
            ConnectivityManager AdminConexiones =
                    (ConnectivityManager)
                            miContexto.getSystemService(miContexto.CONNECTIVITY_SERVICE);
            NetworkInfo InfoRed = AdminConexiones.getActiveNetworkInfo();

            if (InfoRed != null && InfoRed.isConnected()) {
                conectadoWifi = InfoRed.getType() == ConnectivityManager.TYPE_WIFI;
            }else{
                conectadoWifi =  false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conectadoWifi;
    }//Fin conectadoWifi =======================

    public boolean conectadoMobile(){//Devuelve true si esta conectado al Mobile
        try {
            ConnectivityManager AdminConexiones = (ConnectivityManager) miContexto.getSystemService(miContexto.CONNECTIVITY_SERVICE);
            NetworkInfo InfoRed = AdminConexiones.getActiveNetworkInfo();

            if (InfoRed != null && InfoRed.isConnected()) {
                conectadoMobile = InfoRed.getType() == ConnectivityManager.TYPE_MOBILE;
            }else{
                conectadoMobile =  false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conectadoMobile;
    }//Fin conectadoMobile =======================

    public void RevisaConexion() {
        ConnectivityManager AdminConexiones = (ConnectivityManager) miContexto.getSystemService(miContexto.CONNECTIVITY_SERVICE);
        NetworkInfo InfoActual = AdminConexiones.getActiveNetworkInfo();

        if (InfoActual != null && InfoActual.isConnected()) {
            conectadoWifi = InfoActual.getType() == ConnectivityManager.TYPE_WIFI;
            conectadoMobile = InfoActual.getType() == ConnectivityManager.TYPE_MOBILE;

            if(conectadoWifi) {
                UtilesUI.MensajeToast(miContexto, "Conectado con Wifi");
            } else if (conectadoMobile){
                UtilesUI.MensajeToast(miContexto, "Conectado con Mobile");
            }
        } else {
            UtilesUI.MensajeToast(miContexto, "No esta Conectado");
        }
    }//Fin RevisaConexion =======================
}//Fin Util_Redes
