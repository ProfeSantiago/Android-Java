package ulacit.vibrador;

import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Vibrator miVibrador;
    ToneGenerator miTono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miVibrador = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        miTono = new ToneGenerator(AudioManager.STREAM_ALARM, 50); //Volumen = 50

        findViewById(R.id.Vibra_Btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                miVibrador.vibrate(1000); //Vibra x 1 segundo
            }
        });

        findViewById(R.id.Sonido_Btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                miTono.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 300); // milisegundos = 300
            }
        });

    }//Fin onCreate ------------------------------
}
