package ulacit.acelerometro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener  {

    private SensorManager miSensor;
    private Sensor miAcelerometro;

    TextView X_Txt;
    TextView Y_Txt;
    TextView Z_Txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        X_Txt = (TextView) findViewById(R.id.X_Txt);
        Y_Txt = (TextView) findViewById(R.id.Y_Txt);
        Z_Txt = (TextView) findViewById(R.id.Z_Txt);

        miSensor=(SensorManager)getSystemService(SENSOR_SERVICE);
        if (miSensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            miAcelerometro = miSensor.getDefaultSensor(
                    Sensor.TYPE_ACCELEROMETER);
            miSensor.registerListener(this, miAcelerometro,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        X_Txt.setText(Float.toString(Math.round(event.values[0])));
        Y_Txt.setText(Float.toString(Math.round(event.values[1])));
        Z_Txt.setText(Float.toString( Math.round(event.values[2])));
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        miSensor.registerListener(this, miAcelerometro,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        miSensor.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

}
