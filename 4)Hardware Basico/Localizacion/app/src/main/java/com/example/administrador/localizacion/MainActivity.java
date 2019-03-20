package com.example.administrador.localizacion;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_locate;
    TextView latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_locate = (Button)findViewById(R.id.Ubicatex_Btn);
        latitud = (TextView)findViewById(R.id.latitud);
        longitud = (TextView)findViewById(R.id.longitud);

        requestPermissions(new String[]
                { Manifest.permission.ACCESS_FINE_LOCATION},123);


        btn_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MiGPSClass gpsLocator = new MiGPSClass(getApplicationContext());
                Location location = gpsLocator.GetLocation();
                if(location != null){
                    double latitude = location.getLatitude();
                    double longhitud = location.getLongitude();
                    latitud.setText("latitud="+String.valueOf(latitude));
                    longitud.setText("longitud"+String.valueOf(longhitud));
                }
            }
        });
    }
}
