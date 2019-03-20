package com.example.administrador.localizacion;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

public class MiGPSClass implements LocationListener {
    Context miContexto;

    public MiGPSClass(Context elContexto){
        miContexto = elContexto;
    }

    public Location GetLocation(){
        if(ContextCompat.checkSelfPermission(miContexto,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED){
            Toast.makeText(miContexto, "Permiso no concedido",
                    Toast.LENGTH_SHORT).show();
            return  null;
        }
        LocationManager locationManager =
                (LocationManager) miContexto.getSystemService(Context.LOCATION_SERVICE);
        boolean isGPSEnabled =
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(isGPSEnabled){
            locationManager.requestLocationUpdates
                    (LocationManager.GPS_PROVIDER, 6000, 10, this);
            Location location =
                    locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return location;
        }else{
            Toast.makeText(miContexto, "No se detectó el GPS",
                    Toast.LENGTH_SHORT).show();
        }
        return null;
    }//Fin GetLocation

    @Override
    public void onLocationChanged(Location location) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onProviderDisabled(String provider) {}
}