package mobile.ulacit.redesbasico;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

private static boolean conectadoWifi = false;
private static boolean conectadoMobile = false;

    Button CompruebaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CompruebaBtn = (Button) findViewById(R.id.CompruebaBtn);
        CompruebaBtn.setOnClickListener(this);

    }//Fin onCreate  =======================

    private void RevisaConexion() {

        ConnectivityManager AdminConexiones =
                (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

        NetworkInfo InfoActual = AdminConexiones.getActiveNetworkInfo();

        if (InfoActual != null && InfoActual.isConnected()) {

            conectadoWifi = InfoActual.getType() == ConnectivityManager.TYPE_WIFI;
            conectadoMobile = InfoActual.getType() == ConnectivityManager.TYPE_MOBILE;

            if(conectadoWifi) {
                MensajeToast(this, "Conectado con Wifi");
            } else if (conectadoMobile){
                MensajeToast(this, "Conectado con Mobile");
            }
        } else {
            MensajeToast(this, "No esta Conectado");
        }
    }//Fin RevisaConexion =======================

    public void MensajeToast(Context elContexto, String elTexto){
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(elContexto, elTexto, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }//Fin MensajeToast =======================

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.CompruebaBtn:
                RevisaConexion();
                break;
        }//End switch
    }//Fin onClick =======================

}
