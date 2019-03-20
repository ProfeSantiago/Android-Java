package ulacit.libreriaredes;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button CompruebaBtn;
    Util_Redes compruebaRedes;
    Util_UI UtilesUI = new Util_UI();  //Clase para mostrar Toast

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compruebaRedes = new Util_Redes(getApplicationContext());

        CompruebaBtn = (Button) findViewById(R.id.Comprueba_Btn);
        CompruebaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (compruebaRedes.conectadoWifi()) {
                    UtilesUI.MensajeToast(getApplicationContext(), "Conectado al WiFi");
                }else{
                    if (compruebaRedes.conectadoMobile()) {
                        UtilesUI.MensajeToast(getApplicationContext(), "Conectado a Red de Datos");
                    }else{
                        UtilesUI.MensajeToast(getApplicationContext(), "No esta Conectado");
                    }
                }//Fin else

            }//Fin onClick
        });// Fin setOnClickListener ----------------------------

    }//Fin onCreate

}//Fin MainActivity
